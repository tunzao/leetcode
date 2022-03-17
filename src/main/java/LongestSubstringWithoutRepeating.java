import java.util.BitSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class LongestSubstringWithoutRepeating {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        BitSet bitSet = new BitSet(128);
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                bitSet.clear(s.charAt(i - 1));
            }
            for (; j + 1 < s.length() && !bitSet.get(s.charAt(j + 1)); j++) {
                bitSet.set(s.charAt(j + 1));
            }
            max = Math.max(max, j + 1 - i);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sub = new LongestSubstringWithoutRepeating();
        System.out.println(sub.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sub.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sub.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sub.lengthOfLongestSubstring(""));
        System.out.println(sub.lengthOfLongestSubstring(" "));
    }
}
