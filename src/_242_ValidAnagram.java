import java.util.HashMap;
import java.util.Map;

/**
 * Created by feng on 2015/9/6.
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.
 */
public class _242_ValidAnagram {
    public static void main(String[] args) {
        String text1 = "abcdefg";
        String text2 = "abcdfge";
        String text3 = "abcdfgesdd";
        String text4 = "abcdfgg";
        boolean result1 = isAnagram(text1,text2);
        boolean result2 = isAnagram(text1,text3);
        boolean result3 = isAnagram(text1,text4);
        System.out.println(text1+" : "+result1);
        System.out.println(text2+" : "+result2);
        System.out.println(text3+" : "+result3);

    }

    private static boolean isAnagram(String s, String t) {
        if (s==null||t==null||s.length()!=t.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,1);
            }else {
                int count = map.get(c);
                map.replace(c,count+1);
            }
        }
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (!map.containsKey(c)){
                return false;
            }else {
                int count = map.get(c);
                if (count==1){
                    map.remove(c);
                }else {
                    map.replace(c,count-1);
                }
            }
        }
        return true;
    }
}
