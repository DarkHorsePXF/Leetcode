/**
 * Created by feng on 2015/8/24.
 */
public class _171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String test1 = "FXSHRXW";
        String test2 = "AB";
        int result1 = titleToNumber(test1);
        int result2 = titleToNumber(test2);
        System.out.println("result1="+result1);
        System.out.println("result2="+result2);

    }

    private static int titleToNumber(String s) {
        if (s==null||s.length()==0){
            return -1;
        }
        int result = 0;
        int mult = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c<'A'||c>'Z'){
                return -1;
            }
            int diff = c-'A'+1;
            if (result>(Integer.MAX_VALUE-diff)/26){
                return -1;
            }
            result=result*26+diff;
        }
        return result;
    }
}
