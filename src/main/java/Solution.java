import java.util.Arrays;

/**
 * Created by likuan on 14/10/21.
 */
public class Solution {

    /**
     * https://oj.leetcode.com/problems/first-missing-positive/
     * 好吧，这道题是我抄别人的
     * 解决问题的关键是第一个消失的正整数在1-n+1之间
     *
     * @param A
     * @return
     */
    public int firstMissingPositive(int A[]) {

        if (A.length == 0) {
            return 1;
        }
        int[] e = new int[A.length + 2];
        for (int a : A) {
            if (a <= A.length + 1 && a > 0) {
                e[a] = 1;
            }
        }

        for (int i = 1; i < A.length + 2; i++) {
            if (e[i] == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * not solved yet
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int data1 = 0;
        int data2 = 0;
        int[] result = new int[]{-1, -1};
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length && numbers[i] <= target; i++) {
            for (int j = i + 1; j < numbers.length && numbers[j] <= target; j++) {
                if (numbers[i] + numbers[j] == target) {
                    data1 = numbers[i];
                    data2 = numbers[j];
                    break;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == data1 || numbers[i] == data2) {
                if (result[0] == -1) {
                    result[0] = i + 1;
                } else {
                    result[1] = i + 1;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * https://oj.leetcode.com/problems/count-and-say/
     * so easy
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String start = "1";
        StringBuilder end = new StringBuilder();

        for (int j = 1; j < n; j++) {
            int count = 1;
            char c = start.charAt(0);

            for (int i = 1; i < start.length(); i++) {
                if (start.charAt(i) == c) {
                    count++;
                } else {
                    end.append(count).append(c);
                    c = start.charAt(i);
                    count = 1;
                }
            }
            end.append(count).append(c);

            start = end.toString();
            end.setLength(0);
        }
        return start;
    }

    /**
     * @see <a>https://oj.leetcode.com/problems/reverse-integer/</a>
     * so easy
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int y = 0;
        int flag = x < 0 ? -1 : 1;
        x = Math.abs(x);
        while (x > 0) {
            int b = x % 10;
            y = y * 10 + b;
            x /= 10;
        }

        return y * flag;
    }

}
