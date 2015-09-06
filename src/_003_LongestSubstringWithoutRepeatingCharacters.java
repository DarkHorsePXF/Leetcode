import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by feng on 2015/7/23.
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class _003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String string="adbcabcabcccabcdr$#%$#%^^%$";
        System.out.println("输入的字符串："+string.toString());
        System.out.println("最大子串长度："+lengthOfLongestSubstring(string));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s==null){
            return 0;
        }
        HashMap<Character,Integer> hashMap=new HashMap<>();

        int maxLength=0;
        int index=0;
        int curLength=0;

        while(index<s.length()){
            char c=s.charAt(index);
            if(!hashMap.containsKey(c)){
                hashMap.put(c,index);
                curLength++;
                if (maxLength<curLength){
                    maxLength=curLength;
                }
            }else{
                index=hashMap.get(c);
                curLength=0;
                hashMap.clear();
            }
            index++;
        }
        return  maxLength;
    }
}
