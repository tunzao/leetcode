/**
 * Created by likuan on 15/7/7.
 */
public class ValidPalindrome {
    /**
     * Valid Palindrome
     * @see <a>https://leetcode.com/problems/valid-palindrome/</a>
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i=0, j=len-1; i <= j; i++, j--) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            while (!Character.isLetterOrDigit(a) ) {
                i++;
                if (i == len) {
                    return true;
                }
                a = s.charAt(i);
            }
            while (!Character.isLetterOrDigit(b) ) {
                j--;
                if (j == 0) {
                    return true;
                }
                b = s.charAt(j);
            }
            if ( i > j) {
                return true;
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
        }
        return true;

    }
}
