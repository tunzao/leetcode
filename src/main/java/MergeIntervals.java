import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class MergeIntervals {
    /**
     * 先按区间排序
     * 然后合并相邻有交集区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>(intervals.length);
        int[] p = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (!merge(p, intervals[i])) {
                merged.add(p);
                p = intervals[i];
            }
        }
        merged.add(p);
        return merged.toArray(new int[merged.size()][]);

    }

    private boolean merge(int[] before, int[] after) {
        if (before[1] >= after[0]) {
            before[0] = Math.min(before[0], after[0]);
            before[1] = Math.max(before[1], after[1]);
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 3}})));
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(mergeIntervals.merge(null)));
    }
}
