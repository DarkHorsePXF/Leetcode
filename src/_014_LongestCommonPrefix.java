/**
 * Created by feng on 2015/8/5.
 */
public class _014_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={
                "abcaaaaa",
                "abca",
                "abcadhsa",
                "abcaaa",
                "abca"
        };
        String result=longestCommonPrefix(strs);
        System.out.println(result);
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs==null){
            return null;
        }
        if (strs.length==0){
            return "";
        }
        int maxLength=0;
        int minLength=strs[0].length();
        int maxLengthStringPos=0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length()>maxLength){
                maxLength=strs[i].length();
                maxLengthStringPos=i;
            }
            if (strs[i].length()<minLength){
                minLength=strs[i].length();
            }
        }
        StringBuilder sb=new StringBuilder();
        String maxLengString=strs[maxLengthStringPos];
        for (int index = 0; index < minLength; index++) {
            char c=maxLengString.charAt(index);
            for (int pos = 0; pos < strs.length; pos++) {
                if (strs[pos].charAt(index)!=c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
