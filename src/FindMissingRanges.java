import java.util.LinkedList;
import java.util.List;

/**
 * @author likuan
 */
public class FindMissingRanges {
    /**
     * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
     *
     * 示例：
     *
     * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
     * 输出: ["2", "4->49", "51->74", "76->99"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/missing-ranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missing = new LinkedList<>();
        int pre = lower;
        for (int i : nums) {
            buildMissing(missing, pre, i);
            pre = i+1;
        }
        buildMissing(missing, pre, upper+1);
        return missing;
    }

    private void buildMissing(List<String> missing, int pre, int i) {
        int diff = i - pre;
        if (diff == 1) {
            missing.add(String.valueOf(pre));
        } else if (diff > 1) {
            missing.add( pre + "->" + (i - 1));
        }
    }
}
