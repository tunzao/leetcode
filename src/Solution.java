import java.util.Arrays;

/**
 * Created by likuan on 14/10/21.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(1));
    }

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
}
