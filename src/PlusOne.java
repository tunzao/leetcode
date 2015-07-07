import java.util.Arrays;

/**
 * Created by likuan on 15/7/7.
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        System.out.println(Arrays.toString(p.plusOne(new int[]{1, 9, 9})));
    }
    /**
     * Plus One
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
