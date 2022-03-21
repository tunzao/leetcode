import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
 * @author likuan
 */

class TwoSum {

    // 每个数字出现的个数
    private Map<Integer, Integer> numbers = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {

    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        numbers.put(number, numbers.getOrDefault(number, 0)+1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int key : numbers.keySet()) {
            int pair = value - key;
            if (numbers.containsKey(pair) && (key != pair || numbers.get(key) > 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
