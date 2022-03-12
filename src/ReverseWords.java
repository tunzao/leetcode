/**
 * @author likuan
 */
public class ReverseWords {

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     *
     * 示例：
     *
     * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
     * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     *
     * 注意：
     *
     *     单词的定义是不包含空格的一系列字符
     *     输入字符串中不会包含前置或尾随的空格
     *     单词与单词之间永远是以单个空格隔开的
     *
     * 进阶：使用 O(1) 额外空间复杂度的原地解法。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
