/**
 * 从 1 开始，移除所有包含数字 9 的所有整数，例如 9，19，29，……
 * <p>
 * 这样就获得了一个新的整数数列：1，2，3，4，5，6，7，8，10，11，……
 * <p>
 * 给定正整数 n，请你返回新数列中第 n 个数字是多少。1 是新数列中的第一个数字。
 * <p>
 * <p>
 * <p>
 * 样例 1:
 * <p>
 * 输入: 9
 * 输出: 10
 *
 * @author likuan
 */
public class RemoveNine {

    /**
     * 9进制？
     * @param n
     * @return
     */
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

    public static void main(String[] args) {
        RemoveNine removeNine = new RemoveNine();
        System.out.println(removeNine.newInteger(9));
    }
}
