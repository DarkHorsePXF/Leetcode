/**
 * Created by feng on 2015/7/24.
 */
public class _009_PalindromeNumber {
    public static void main(String[] args) {
        int test= 1000000001;
        boolean isPalindromeNumber=isPalindromeNumber(test);
        System.out.println(isPalindromeNumber);
        long l=test;
        System.out.println(l);
    }

    private static boolean isPalindromeNumber(int x) {
        if (x<0)
            return false;
        if (x==0)
            return true;
        long num=x;
        int bits=0;
        long pow=1;
        while (num>0){
            num/=10;
            pow*=10;
            bits++;
        }
        pow/=10;
        int half=bits/2;
        long temp=x;
        int high;
        int low;
        for (int i = 0; i < half ; i++) {
            high = (int) (temp/pow);
            low = (int) (temp%10);
            temp%=pow;
            temp/=10;
            pow/=100;
            System.out.println("high="+high+"  low="+low);
            if (high!=low){
                return false;
            }

        }
        return true;
    }
}
