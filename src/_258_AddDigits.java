/**
 * Created by feng on 2015/9/6.
 */
public class _258_AddDigits {
    public static void main(String[] args) {
        int text1 = -5;
        int text2 = 0;
        int text3 = 123;
        int text4 = 157;
        int result1 = addDigits1(text1);
        int result2 = addDigits1(text2);
        int result3 = addDigits1(text3);
        int result4 = addDigits1(text4);
        System.out.println(text1+":"+result1);
        System.out.println(text2+":"+result2);
        System.out.println(text3+":"+result3);
        System.out.println(text4+":"+result4);
    }

    private static int addDigits(int num) {
        if (num<0)
            return -1;
        if (num==0)
            return 0;
        int result = 0;
        boolean isDigit = false;
        while (!isDigit){
            while (num>0){
                result += num%10;
                num = num/10;
            }
            if (result<10){
                isDigit = true;
            }else {
                num = result;
                result = 0;
            }
        }
        return result;
    }

    private static int addDigits1(int num){
        if (num<0)
            return -1;
        if (num==0)
            return 0;
        return 1+(num-1)%9;
    }
}
