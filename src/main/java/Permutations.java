import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new LinkedList<>();
        List<Integer> output = new ArrayList<>(nums.length);
        for (int n: nums) {
            output.add(n);
        }
        int len = nums.length;
        backtrack(len, permutations, output, 0);
        return permutations;
    }

    private void backtrack(int len, List<List<Integer>> permutations, List<Integer> output, int first) {
        if (first == len) {
            permutations.add(new ArrayList<>(output));
        }
        for (int i=first; i< len;i++) {
            Collections.swap(output, first, i);
            backtrack(len, permutations, output, first+1);
            Collections.swap(output, first, i);
        }
    }
}
