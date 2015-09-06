/**
 * Created by feng on 2015/8/24.
 */
public class _058_LengthOfLastWord {
    public static void main(String[] args) {
        String test1 = "Hello World";
        String test2 = "Hello WoRld   ";
        String test3 = "Hello";
        String test4 = "Hello World1";
        int result1 = lengthOfLastWord(test1);
        int result2 = lengthOfLastWord(test2);
        int result3 = lengthOfLastWord(test3);
        int result4 = lengthOfLastWord(test4);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    private static int lengthOfLastWord(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        int count = 0;
        boolean hasWord = false;
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if (!hasWord&&c==' '){
                continue;
            }
            if ((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
                hasWord=true;
                count++;
            }else if (c==' '){
                return count;
            }else {
                return 0;
            }

        }
        if (hasWord){
            return count;
        }
        return 0;
    }
}
