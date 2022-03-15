import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定员工的 schedule 列表，表示每个员工的工作时间。
 * <p>
 * 每个员工都有一个非重叠的时间段  Intervals 列表，这些时间段已经排好序。
 * <p>
 * 返回表示 所有 员工的 共同，正数长度的空闲时间 的有限时间段的列表，同样需要排好序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * 输出：[[3,4]]
 * 解释：
 * 共有 3 个员工，并且所有共同的
 * 空间时间段是 [-inf, 1], [3, 4], [10, inf]。
 * 我们去除所有包含 inf 的时间段，因为它们不是有限的时间段。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * 输出：[[5,6],[7,9]]
 * <p>
 * <p>
 * <p>
 * （尽管我们用 [x, y] 的形式表示 Intervals ，内部的对象是 Intervals 而不是列表或数组。例如，schedule[0][0].start = 1, schedule[0][0].end = 2，并且 schedule[0][0][0] 是未定义的）
 * <p>
 * 而且，答案中不包含 [5, 5] ，因为长度为 0。
 * <p>
 * <p>
 * <p>
 * 注：
 * <p>
 * schedule 和 schedule[i] 为长度范围在 [1, 50]的列表。
 * 0 <= schedule[i].start < schedule[i].end <= 10^8。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-free-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class EmployeeFreeTime {

    /**
     * 1. 求出所有员工的空闲时段
     * 2. 所有员工的空闲时段求交集
     *
     * 另外两种解法：事件（扫描线）和优先队列
     *
     * @param schedule
     * @return
     */
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<List<Interval>> free = freeInterval(schedule);
        List<Interval> joinFree = new ArrayList<>();
        joinFree.add(new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE));
        for (List<Interval> intervals : free) {
            List<Interval> newJoin = new ArrayList<>();
            for (Interval j : joinFree) {
                for (Interval i : intervals) {
                    Interval inter = intersect(j, i);
                    if (inter != null) {
                        newJoin.add(inter);
                    }
                }
            }
            joinFree = newJoin;
        }
        return joinFree.stream().filter(i -> {
            return i.start > Integer.MIN_VALUE && i.end < Integer.MAX_VALUE;
        }).collect(Collectors.toList());
    }

    private List<List<Interval>> freeInterval(List<List<Interval>> schedule) {
        List<List<Interval>> free = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            List<Interval> f = new ArrayList<>();
            Interval head = new Interval(Integer.MIN_VALUE, intervals.get(0).start);
            f.add(head);
            Interval tail = new Interval(intervals.get(intervals.size()-1).end, Integer.MAX_VALUE);
            for (int i = 0; i < intervals.size() - 1; i++) {
                f.add(new Interval(intervals.get(i).end, intervals.get(i + 1).start));
            }
            f.add(tail);
            free.add(f);
        }
        return free;
    }

    private Interval intersect(Interval j, Interval i) {
        int min = Math.max(j.start, i.start);
        int max = Math.min(j.end, i.end);
        if (min < max) {
            return new Interval(min, max);
        }
        return null;
    }

    public static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static void main(String[] args) {
        EmployeeFreeTime freeTime = new EmployeeFreeTime();

        List<List<Interval>> schedule = Lists.newArrayList(
                Lists.newArrayList(new Interval(1, 2), new Interval(5, 6)),
                Lists.newArrayList(new Interval(1, 3)),
                Lists.newArrayList(new Interval(4, 10))
        );
//        System.out.println(freeTime.employeeFreeTime(schedule));

        schedule = Lists.newArrayList(
                Lists.newArrayList(new Interval(1, 3), new Interval(6, 7)),
                Lists.newArrayList(new Interval(2, 4)),
                Lists.newArrayList(new Interval(2, 5), new Interval(9, 12))
        );
        System.out.println(freeTime.employeeFreeTime(schedule));
    }

}
