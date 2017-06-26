import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by likuan on 2017-06-26.
 * <p>
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 *
 * @author likuan
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[] {-3,4,3,90}, 0)));
    }
}
