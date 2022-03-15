/**
 * 给定一个 非空 字符串，将其编码为具有最短长度的字符串。
 * <p>
 * 编码规则是：k[encoded_string]，其中在方括号 encoded_string 中的内容重复 k 次。
 * <p>
 * 注：
 * <p>
 * k 为正整数
 * 如果编码的过程不能使字符串缩短，则不要对其进行编码。如果有多种编码方式，返回 任意一种 即可
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaa"
 * 输出："aaa"
 * 解释：无法将其编码为更短的字符串，因此不进行编码。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "aaaaa"
 * 输出："5[a]"
 * 解释："5[a]" 比 "aaaaa" 短 1 个字符。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "aaaaaaaaaa"
 * 输出："10[a]"
 * 解释："a9[a]" 或 "9[a]a" 都是合法的编码，和 "10[a]" 一样长度都为 5。
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "aabcaabcd"
 * 输出："2[aabc]d"
 * 解释："aabc" 出现两次，因此一种答案可以是 "2[aabc]d"。
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = "abbbabbbcabbbabbbc"
 * 输出："2[2[abbb]c]"
 * 解释："abbbabbbc" 出现两次，但是 "abbbabbbc" 可以编码为 "2[abbb]c"，因此一种答案可以是 "2[2[abbb]c]"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 150
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/encode-string-with-shortest-length
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class EncodeShortestString {

    String[][] dp;
    /**
     * @param s
     * @return
     */
    public String encode(String s) {

        /**
         * 最优解问题，涉及到贪心算法还是动态规划？区间动态规划，有现成的模板解题
         * 如何确定能不能被编码？
         *
         * 重复子串长度大于3则一定能编码
         *
         * k是重复次数，l是子串长度
         * k*l > l+3 -> k > (l+3)/l
         * 长度等于3时，重复次数要大于2
         * 长度等于2时，重复次数要大于2.5
         * 长度等于1时，重复次数要大于4
         *
         * 如何确定是最短编码？
         *
         * 子串缩减的长度 = k*l-(l+3) = (k-1)l - 3
         *
         */
        int n = s.length();
        dp = new String[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i=0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = lc459(s, i, j);
                if (len > 4) {
                    for (int k = i; k < j; k++) {
                        String split = dp[i][k] + dp[k+1][j];
                        if (dp[i][j].length() > split.length()) dp[i][j] = split;
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    /**
     * 没太看懂
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    private String lc459(String s, int start, int end) {
        s = s.substring(start, end + 1);
        if (s.length() < 5) {
            return s;
        }
        int p = (s + s).indexOf(s, 1); // 这是什么原理?
        if (p != s.length()) {
            int c = s.length() / p;
            return c + "[" + dp[start][start + p - 1] + "]";
        }
        return s;
    }
}
