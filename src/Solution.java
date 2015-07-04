import java.util.Arrays;

/**
 * Created by likuan on 14/10/21.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 9, 9})));
    }

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

    public int aoti(String str) {
        str = str.toLowerCase().trim();
        if (str.length() == 0) {
            return 0;
        }
        int x = 0;
        int flag = 1;
        int base = 10;
        int start = 0;
        if (str.charAt(0) == '+') {
            start = 1;
        } else if (str.charAt(0) == '-') {
            start = 1;
            flag = -1;
        }
        if (str.charAt(start) == '0') {
            if (str.charAt(start + 1) == 'x') {
                start += 2;
                base = 16;
            } else {
                start += 1;
                base = 8;
            }
        }
        if (base != 16) {
            for (; start < str.length(); start++) {
                x = x * base + str.charAt(start) - '0';
            }
        } else {
            x = atoi16(str, start);
        }
        return x * flag;
    }

    private int atoi16(String str, int start) {
        int x = 0;
        for (; start < str.length(); start++) {
            if (str.indexOf(start) > '9') {
                x = x * 16 + str.charAt(start) - 'a' + 10;
            } else {
                x = x * 16 + str.charAt(start) - '0';
            }
        }
        return x;
    }

    /**
     * Valid Palindrome
     * @see <a>https://leetcode.com/problems/valid-palindrome/</a>
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i=0, j=len-1; i <= j; i++, j--) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            while (!Character.isLetterOrDigit(a) ) {
                i++;
                if (i == len) {
                    return true;
                }
                a = s.charAt(i);
            }
            while (!Character.isLetterOrDigit(b) ) {
                j--;
                if (j == 0) {
                    return true;
                }
                b = s.charAt(j);
            }
            if ( i > j) {
                return true;
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
        }
        return true;

    }

    /**
     *
     * @see <a>https://leetcode.com/problems/plus-one/</a>
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int c = 0;
        for (int i=digits.length-1; i >= 0; i--) {
            int a = digits[i] + (i == digits.length - 1 ? 1 : 0) + c;
            if (a > 9) {
                c = 1;
                a %= 10;
                digits[i] = a;
            } else {
                c = 0;
                digits[i] = a;
                break;
            }
        }
        if (c == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = c;
            for (int i=0; i<digits.length; i++) {
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        } else {
            return digits;
        }
    }



}
