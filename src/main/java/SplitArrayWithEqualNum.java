import java.util.HashSet;

/**
 * 给定一个有 n 个整数的数组 nums ，如果能找到满足以下条件的三元组  (i, j, k)  则返回 true ：
 * <p>
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * 子数组 (0, i - 1) ， (i + 1, j - 1) ， (j + 1, k - 1) ， (k + 1, n - 1) 的和应该相等。
 * <p>
 * 这里我们定义子数组 (l, r) 表示原数组从索引为 l 的元素开始至索引为 r 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1,2,1,2,1]
 * 输出: True
 * 解释:
 * i = 1, j = 3, k = 5.
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,1,2,1,2,1,2]
 * 输出: false
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == nums.length
 * 1 <= n <= 2000
 * -106 <= nums[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class SplitArrayWithEqualNum {

    /**
     * 官方答案5：HasSet+累加和
     * @param nums
     * @return
     */
    public boolean splitArray(int[] nums) {
        if (nums.length < 7) {
            return false;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        for (int j = 3; j < nums.length - 3; j++) {
            HashSet<Integer> leftSum = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                int a = sum(sums, 0, i - 1);
                int b = sum(sums, i + 1, j - 1);
                if (a == b) {
                    leftSum.add(a);
                }
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                int a = sum(sums, j + 1, k - 1);
                int b = sum(sums, k + 1, nums.length - 1);
                if (a == b && leftSum.contains(a)) {
                    return true;
                }
            }
        }
        return false;

    }

    int sum(int[] sums, int start, int end) {
        if (start == 0) {
            return sums[end];
        }
        return sums[end] - sums[start - 1];
    }

    public static void main(String[] args) {
        SplitArrayWithEqualNum split = new SplitArrayWithEqualNum();
        System.out.println(split.splitArray(new int[]{1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(split.splitArray(new int[]{1, 2, 1, 2, 1, 2, 1}));
    }
}
