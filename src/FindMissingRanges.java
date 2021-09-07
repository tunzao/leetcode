import java.util.LinkedList;
import java.util.List;

/**
 * @author likuan
 */
public class FindMissingRanges {
    /**
     * https://leetcode-cn.com/problems/missing-ranges/
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
