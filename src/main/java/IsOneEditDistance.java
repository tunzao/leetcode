/**
 * @author likuan
 */
public class IsOneEditDistance {

    /**
     * https://leetcode-cn.com/problems/one-edit-distance/
     *
     * 依次遍历两个字符串，
     * 如果长度相等且对应位置字符不同的个数超过1个则false
     * 如果不相等
     * 当对应位置字符串不相等时，如果长串的下一个字符与短串的当前相等，则移动长串游标到下一个字符位置，出现不对等次数大于1则false
     *
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (Math.abs(sLen - tLen) > 1) {
            return false;
        }
        int diffCnt = 0;
        int i = 0, j = 0;
        for (; i < sLen && j < tLen; i++, j++) {
            char a = s.charAt(i);
            char b = t.charAt(j);
            if (a != b) {
                diffCnt++;
                if (tLen < sLen && i+1 < sLen && s.charAt(i + 1) == b) {
                    i++;
                }
                if (sLen < tLen && j+1 < tLen && t.charAt(j + 1) == a) {
                    j++;
                }
            }
        }
        if (i < sLen || j < tLen) {
            diffCnt++;
        }

        return diffCnt == 1;
    }
}
