/**
 * Created by feng on 2015/7/23.
 */
public class _005_LongestPalindromicSubString {
    public static void main(String[] args) {
        String s="bb";
        System.out.println(longestPalindrome2(s));
    }

    /*
    暴力求解：O(n^3)
     */
    static String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int maxLength=0;
        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                if (isPalinromic(s,i,j)){
                    int leng=j-i+1;
                    if (maxLength<leng){
                        maxLength=leng;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }

    private static boolean isPalinromic(String s, int start, int end) {
        for (int index = start; index <= (start+end)/2; index++) {
            if (s.charAt(index)!=s.charAt(end-index+start))
                return false;
        }
        return true;
    }

    /*
    遍历每个点，同时从左右出发：O（n^2）
     */
    static String longestPalindrome2(String s){
        int length=s.length();
        if (length==0)
            return "";
        String longest=s.substring(0,1);
        for (int index = 0; index < length; index++) {
            String str1=getPalindromeExpandAroundCenter(s,index,index);
            if (str1.length()>longest.length())
                longest=str1;

            String str2=getPalindromeExpandAroundCenter(s,index,index+1);
            if (str2.length()>longest.length())
                longest=str2;

        }
        return longest;
    }

    private static String getPalindromeExpandAroundCenter(String s, int center1, int center2) {
        int l=center1;
        int r=center2;
        while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }


}
