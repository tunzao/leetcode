/**
 * @author likuan
 */
public class LengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int maxLen = 0;
        char a = s.charAt(start);
        char non = (char) -1;
        char b = non;
        char c = non;
        char last = a;
        int nextStrStart = 0;
        for (int i = 1; i < s.length(); ) {
            c = s.charAt(i);
            if (c == last) {
                i++;
                continue;
            }
            if (b == non) {
                nextStrStart = i++;
                b = c;
            } else if (c == a || c == b) {
                nextStrStart = i++;
            } else {
                maxLen = Math.max(maxLen, i - start);
                i = nextStrStart + 1;
                start = nextStrStart;
                a = s.charAt(start);
                c = a;
                b = non;
            }
            last = c;
        }
        return Math.max(maxLen, s.length() - start);
    }
}
