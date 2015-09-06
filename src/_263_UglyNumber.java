/**
 * Created by feng on 2015/9/6.
 */
public class _263_UglyNumber {
    public static void main(String[] args) {
        int text1 = -5;
        int text2 = 1;
        int text3 = 16;
        int text4 = 17;
        boolean result1 = isUgly(text1);
        boolean result2 = isUgly(text2);
        boolean result3 = isUgly(text3);
        boolean result4 = isUgly(text4);
        System.out.println(text1+":"+result1);
        System.out.println(text2+":"+result2);
        System.out.println(text3+":"+result3);
        System.out.println(text4+":"+result4);

    }

    private static boolean isUgly(int num) {
        if (num<=0)
            return false;
        if (num==1)
            return true;
        int[] factors = {2,3,5};
        boolean dividable = true;
        while (dividable){
            dividable = false;
            for (int i = 0; i < factors.length; i++) {
                if (num%factors[i]==0){
                    num = num/factors[i];
                    dividable = true;
                }
            }
            if (!dividable)
                break;
        }
        if (num==1){
            return true;
        }
        return false;
    }
}
