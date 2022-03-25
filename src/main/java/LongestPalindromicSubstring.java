/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 1000
 *     s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author likuan
 */
public class LongestPalindromicSubstring {

    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()]; // s(i,j)是否是回文串
        int start = 0;
        int end = 0;
        int maxLen = 1;
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                int j = i + len;
                if (i == j) {
                    dp[i][j] = true;
                    continue;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && (j-i+1>maxLen)) {
                   start = i;
                   end   = j;
                   maxLen = j-i+1;
                }
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring palindromic = new LongestPalindromicSubstring();
        System.out.println(palindromic.longestPalindrome("b"));
        System.out.println(palindromic.longestPalindrome(""));
        System.out.println(palindromic.longestPalindrome("babad"));
        System.out.println(palindromic.longestPalindrome("bb"));
    }
}
