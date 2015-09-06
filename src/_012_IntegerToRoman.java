/**
 * Created by feng on 2015/8/5.
 */
public class _012_IntegerToRoman {
    public static void main(String[] args) {
        int num=2348;
        String result=intToRoman(num);
        System.out.println(result);
    }

    private static String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        while (num>0){
            for (int i = 0; i < values.length; i++) {
                if (values[i]<=num){
                    num-=values[i];
                    sb.append(romans[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
