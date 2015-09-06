/**
 * Created by feng on 2015/7/23.
 */
public class _008_StringToInteger {
    public static void main(String[] args) {
        String str="3135451231154";
        int result=string2Integer(str);
        System.out.println(result);

    }

    private static int string2Integer(String str) {
        final int INVALID_RETURN=0;
        if (str==null||str.length()==0)
            return INVALID_RETURN;
        boolean isNegative=false;
        int result=INVALID_RETURN;
        boolean isStarted=false;
        boolean hasZero=false;

        if (str.charAt(0)=='-'){
            //只有一个负数，后面无数字的话，非法输入
            if (str.length()==1|| hasZero)
                return INVALID_RETURN;
            isNegative=true;
            hasZero=true;
        }
        int start=0;

        //确定最大数的十位数前的数的最大值，即 214748364
        int maxNum=Integer.MAX_VALUE/10;

        //正数最大数（2147483647）的个位数为7，负数最大数（-2147483648）的个位数为8
        int maxTemp=7;
        if (isNegative) {
            start = 1;
            maxTemp = 8;
        }

        if (str.charAt(0)=='+'){
            if (str.length()==1|| hasZero)
                return INVALID_RETURN;
            start = 1;
            hasZero=true;
        }
        int num=0;

        boolean isOverFlow=false;

        for (int index = start; index < str.length(); index++) {
            char c=str.charAt(index);

            if (isStarted==false){
                if (c>'0'&& c<'9'){
                    isStarted=true;
                }else if (c=='0'){
                    hasZero=true;
                    continue;
                }else if (c==' '){
                    if (hasZero)
                        return INVALID_RETURN;
                    continue;
                }else if (c=='+'){
                    if (index==str.length()-1|| hasZero){
                        return INVALID_RETURN;
                    }
                    hasZero=true;
                    continue;
                }else if (c=='-'){
                    isNegative=true;
                    if (index==str.length()-1|| hasZero){
                        return INVALID_RETURN;
                    }
                    hasZero=true;
                    continue;
                }
            }

            if (c<'0'||c>'9')
                break;

            int temp=c-'0';
            if (num>=maxNum){
                if (num>maxNum){
                    isOverFlow=true;
                    break;
                }
                if (temp>maxTemp){
                    isOverFlow=true;
                    break;
                }
            }

            num=num*10 + temp;
        }

        if (isNegative){
            if (isOverFlow)
                return Integer.MIN_VALUE;
            result=-num;
        }else{
            if (isOverFlow)
                return  Integer.MAX_VALUE;
            result=num;
        }
        return result;
    }
}
