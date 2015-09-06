/**
 * Created by feng on 2015/8/4.
 */
public class _011_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height={2,6,2,4,3,1,5};
        int maxArea=maxArea2(height);
        System.out.println(maxArea);
    }
    /*
    暴力求解 O（n^2）
     */
    private static int maxArea(int[] height) {
        if (height==null){
            return -1;
        }
        if (height.length==0){
            return -1;
        }
        int maxArea=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (i==j){
                    continue;
                }else {
                    int temp=0;
                    if (i>j){
                        temp=min(height[i],height[j])*(i-j);
                    }else {
                        temp=min(height[i],height[j])*(j-i);
                    }
                    if (temp>maxArea){
                        System.out.println("i="+i+"  j="+j);
                        maxArea=temp;
                    }
                }

            }
        }
        return maxArea;
    }

    private static int min(int a,int b){
        return a<b?a:b;
    }

    private static int max(int a,int b){
        return a>b?a:b;
    }


    private static int maxArea2(int[] height){
        if (height==null){
            return -1;
        }
        if (height.length==0){
            return -1;
        }
        int maxArea=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            maxArea=max(maxArea,min(height[left],height[right])*(right-left));
            if (height[left]>height[right]){
                int k=right;
                while (k>left&&height[right]>=height[k]){
                    k--;
                }
                right=k;
            }else {
                int k=left;
                while (k<right&&height[left]>=height[k]){
                    k++;
                }
                left=k;
            }
        }
        return maxArea;
    }
}
