import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by feng on 2015/8/5.
 */
public class ThreeSum {
    public final int aa;
    public static void main(String[] args) {
        int[] nums={3,1,-2,0,-2,-1,2,1,-2,0,0};
        int[] test={3,0,-2,-1,1,2};
        System.out.println(threeSum(test));
//        System.out.println(threeSum(nums));

    }
    ThreeSum(){
        aa=1;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums==null){
            return null;
        }
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<3){
            return result;
        }

        int mid=divide(nums);
        System.out.println(Arrays.toString(nums));
        int negetive=0;

        while (negetive<mid){
            int positive=mid;
            while (positive<nums.length){
                int twoSum=nums[positive]+nums[negetive];
                if (twoSum>=0){
                    int left=negetive+1;
                    while (left<mid){
                        if (nums[left]+twoSum==0){
                            List<Integer> list=new ArrayList<>();
                            list.add(min(nums[negetive],nums[left]));
                            list.add(max(nums[negetive], nums[left]));
                            list.add(nums[positive]);
                            addToList(result,list);
                        }
                        left++;
                    }
                }else {
                    int right=positive+1;
                    while (right<nums.length){
                        if (nums[right]+twoSum==0){
                            List<Integer> list=new ArrayList<>();
                            list.add(nums[negetive]);
                            list.add(min(nums[positive], nums[right]));
                            list.add(max(nums[positive], nums[positive]));
                            addToList(result, list);
                        }
                        right++;
                    }
                }
                positive++;
            }
            negetive++;
        }

        if (isMoreThanThreeZero(nums,mid)){
            List<Integer> list=new ArrayList<>();
            while (list.size()<3){
                list.add(0);
            }
            addToList(result,list);
        }

        return result;
    }

    private static void addToList(List<List<Integer>> list, List<Integer> itemAdd) {
        if (list.size()==0){
            list.add(itemAdd);
            return;
        }
        for(List<Integer> item:list){
            if (item.get(0)==itemAdd.get(0))
                if (item.get(1)==itemAdd.get(1))
                    if (item.get(2)==itemAdd.get(2))
                        return;
        }
        list.add(itemAdd);
    }

    private static boolean isMoreThanThreeZero(int[] nums, int length) {
        int zeroNum=0;
        for (int i = 0; i < length; i++) {
            if (nums[i]==0){
                zeroNum++;
                if (zeroNum==3)
                    return true;
            }
        }
        return false;
    }


    /*
    @ return 非负数的下标
     */
    private static int divide(int[] nums) {
        int index=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=0){
                index++;
                swap(nums,index,i);
            }
        }
        return ++index;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i==j)
            return;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private static int min(int a,int b){
        return a<b?a:b;
    }

    private static int max(int a,int b){
        return a>b?a:b;
    }
}
