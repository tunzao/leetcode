/**
 * @author likuan
 */
public class ReverseWords {

    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-ii/
     *
     * @param s
     */
    public void reverseWords(char[] s) {
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i);
                start = i + 1;
            }
        }
        reverse(s, start, s.length);
        reverse(s, 0, s.length);
    }

    private void reverse(char[] s, int start, int end) {
        for (int a = start, b = end - 1; a < b; a++, b--) {
            char t = s[a];
            s[a] = s[b];
            s[b] = t;
        }
    }
}
