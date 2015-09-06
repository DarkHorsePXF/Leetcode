/**
 * Created by feng on 2015/8/5.
 */
public class _013_RomanToInteger {
    public static void main(String[] args) {
        String s="MMCCCXLVIII";
        int result=romanToInt(s);
        System.out.println(result);
    }

    private static int romanToInt(String s) {
        if (s==null){
            return -1;
        }
        if (s.length()==0){
            return 0;
        }
        int result=0;
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i <s.length(); i++) {
            switch (s.charAt(i)){
                case 'M':{
                    result+=1000;
                    break;
                }
                case 'C':{
                    if (i+1<s.length()){
                        if (s.charAt(i+1)=='M'){
                            i++;
                            result+=900;
                            break;
                        }else if (s.charAt(i+1)=='D'){
                            i++;
                            result+=400;
                            break;
                        }
                    }
                    result+=100;
                    break;
                }
                case 'D':{
                    result+=500;
                    break;
                }
                case 'X':{
                    if (i+1<s.length()){
                        if (s.charAt(i+1)=='C'){
                            i++;
                            result+=90;
                            break;
                        }else if (s.charAt(i+1)=='L'){
                            i++;
                            result+=40;
                            break;
                        }
                    }
                    result+=10;
                    break;
                }
                case 'L':{
                    result+=50;
                    break;
                }
                case 'I':{
                    if (i+1<s.length()){
                        if (s.charAt(i+1)=='X'){
                            i++;
                            result+=9;
                            break;
                        }else if (s.charAt(i+1)=='V'){
                            i++;
                            result+=4;
                            break;
                        }
                    }
                    result+=1;
                    break;
                }
                case 'V':{
                    result+=5;
                    break;
                }
                default:
                    break;
            }
        }
        return result;
    }
}
