/**
 * 给你一个包含 n 个整数的数组 nums ，和一个整数 k 。
 * <p>
 * 请你找出 长度大于等于 k 且含最大平均值的连续子数组。并输出这个最大平均值。任何计算误差小于 10-5 的结果都将被视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75000
 * 解释：
 * - 当长度为 4 的时候，连续子数组平均值分别为 [0.5, 12.75, 10.5] ，其中最大平均值是 12.75 。
 * - 当长度为 5 的时候，连续子数组平均值分别为 [10.4, 10.8] ，其中最大平均值是 10.8 。
 * - 当长度为 6 的时候，连续子数组平均值分别为 [9.16667] ，其中最大平均值是 9.16667 。
 * 当取长度为 4 的子数组（即，子数组 [12, -5, -6, 50]）的时候，可以得到最大的连续子数组平均值 12.75 ，所以返回 12.75 。
 * 根据题目要求，无需考虑长度小于 4 的子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 104
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class FindMaxAvg {

    public double findMaxAverage(int[] nums, int k) {
        double max_val = Integer.MIN_VALUE;
        double min_val = Integer.MAX_VALUE;
        for (int n: nums) {
            max_val = Math.max(max_val, n);
            min_val = Math.min(min_val, n);
        }
        double prev_mid = max_val, error = Integer.MAX_VALUE;
        while (error > 0.00001) {
            double mid = (max_val + min_val) * 0.5;
            if (check(nums, mid, k))
                min_val = mid;
            else
                max_val = mid;
            error = Math.abs(prev_mid - mid);
            prev_mid = mid;
        }
        return min_val;
    }
    public boolean check(int[] nums, double mid, int k) {
        double sum = 0, prev = 0, min_sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i] - mid;
        if (sum >= 0)
            return true;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;
            min_sum = Math.min(prev, min_sum);
            if (sum >= min_sum)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FindMaxAvg findMaxAvg = new FindMaxAvg();
        System.out.println(findMaxAvg.findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAvg.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAvg.findMaxAverage(new int[]{3, 6, 0, 1, 8, 0}, 3));
        System.out.println(findMaxAvg.findMaxAverage(new int[]{-1}, 1));
        System.out.println(findMaxAvg.findMaxAverage(new int[]{4, 0, 4, 3, 3}, 5));
    }
}
