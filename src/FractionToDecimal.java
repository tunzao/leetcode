import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by likuan on 15/7/7.
 *
 * @see <a>https://leetcode.com/problems/fraction-to-recurring-decimal/</a>
 */
public class FractionToDecimal {

    public static void main(String[] args) {
        FractionToDecimal f = new FractionToDecimal();
        System.out.println(f.fractionToDecimal(1, 7));
        System.out.println(f.fractionToDecimal(1, 6));
        System.out.println(f.fractionToDecimal(1, 214748364));
        System.out.println(f.fractionToDecimal(2, 3));
        System.out.println(f.fractionToDecimal(2, 1));
        System.out.println(f.fractionToDecimal(-2, 1));
        System.out.println(f.fractionToDecimal(-50, 8));
        System.out.println(f.fractionToDecimal(50, 8));
        System.out.println(f.fractionToDecimal(0, 8));
    }

    /**
     * 把 int 转成long，这样就不用考虑极大极小数据的问题了
     * 就是模拟手算，当遇到重复的余数是说明是无限循环小数，另外循环小数的循环位数不会超过N-1位,N为分母
     * @see <a>https://zh.wikipedia.org/wiki/%E5%BE%AA%E7%8E%AF%E5%B0%8F%E6%95%B0</a>
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        int sign = numerator < 0 ? (denominator < 0 ? 1 : -1) : (denominator < 0 ? -1 : 1);
        long c = (long) numerator;
        long d = (long) denominator;

        long a = Math.abs(c / d);
        long b = Math.abs(c % d);
        d = Math.abs(d);
        if (b != 0) {
            long g = gcd(b, d);
            b /= g;
            d /= g;
            List<Long> xiaoshu = new ArrayList<Long>();
            Map<Long, Integer> mods = new HashMap<Long, Integer>();
            mods.put(b, 0);
            for (int i = 0; i < d - 1; i++) {
                b *= 10;
                xiaoshu.add(b / d);
                b = b % d;
                if (b == 0)
                    break;
                if (mods.containsKey(b)) {
                    // 循环小数
                    StringBuilder sb = new StringBuilder();
                    int start = mods.get(b);
                    if (sign < 0) {
                        sb.append("-");
                    }
                    sb.append(a).append(".");
                    int k = 0;
                    for (; k < start; k++)
                        sb.append(xiaoshu.get(k));
                    sb.append("(");
                    for (; k < xiaoshu.size(); k++) {
                        sb.append(xiaoshu.get(k));
                    }
                    sb.append(")");
                    return sb.toString();
                } else {
                    mods.put(b, i+1);
                }
            }
            while (b != 0) {
                b *= 10;
                xiaoshu.add(b / d);
                b %= d;
            }
            StringBuilder sb = new StringBuilder();
            if (sign < 0) {
                sb.append("-");
            }
            sb.append(a).append(".");
            for (long x : xiaoshu) {
                sb.append(x);
            }
            return sb.toString();
        }
        return sign < 0 ? String.valueOf(-a) : String.valueOf(a);

    }

    private long gcd(long a, long b) {
        long res = a % b;
        while (res != 0) {
            a = b;
            b = res;
            res = a % b;
        }
        return b;
    }

}
