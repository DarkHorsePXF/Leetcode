import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by feng on 2015/7/23.
 */
public class _004_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,3,4,5,6};
        int[] nums2={3,4,5,6,6,7};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }


    /*
    merge求解，时间复杂度O(m+n)，空间复杂度O(m+n)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null){
            return 0;
        }
        double result=0;
        int length1=nums1.length;
        int length2=nums2.length;
        int length=length1+length2;
        int [] nums=new int[length];
        int index1=0;
        int index2=0;
        for (int i = 0; i <nums.length ; i++) {
            if (index1>=length1){
                nums[i]=nums2[index2++];
            }else if(index2>=length2){
                nums[i]=nums1[index1++];
            }else{
                if (nums1[index1]>nums2[index2]){
                    nums[i]=nums2[index2++];
                }else{
                    nums[i]=nums1[index1++];
                }

            }
        }
        if(length/2==0){
            return nums[0];
        }else{
            int medium=(length-1)/2;
            if (length%2==0){
                result=(nums[medium]+nums[medium+1])/2.0;
            }else{
                result=nums[medium];
            }
        }

        return result;
    }

    /*
    二分求解：时间复杂度O(log(m+n))，空间复杂度O(1)
     */
//    public static double findMedianSortedArrays02(int[] nums1, int[] nums2){
//        if (nums1==null||nums2==null){
//            return 0;
//        }
//        double result=0;
//        int length=nums1.length+nums2.length;
//        if (length%2==0){
//            return findKth(nums1,nums2,length/2);
//        }else{
//            return (findKth(nums1,nums2,length/2-1)+findKth(nums1,nums2,length/2+1))/2.0;
//        }
//    }
//
//    private static double findKth(int[] nums1, int[] nums2, int k) {
//        return findKth(nums1,nums1.length-1,nums2,nums2.length-1,k);
//    }
//
//    private static double findKth(int[] nums1, int m, int[] nums2, int n, int k) {
//        if(m<n)
//            return findKth(nums2,n,nums1,m,k);
//        if(m==0)
//            return nums2[k];
//        if (k==0)
//            return Math.min(nums1[0],nums2[0]);
//
//        int pa=Math.min(k/2,);
//        //FIXME
//
//
//
//    }


}
