import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 整数数组 stations 表示 水平数轴 上各个加油站的位置。给你一个整数 k 。
 * <p>
 * 请你在数轴上增设 k 个加油站，新增加油站可以位于 水平数轴 上的任意位置，而不必放在整数位置上。
 * <p>
 * 设 penalty() 是：增设 k 个新加油站后，相邻 两个加油站间的最大距离。
 * 请你返回 penalty() 可能的最小值。与实际答案误差在 10-6 范围内的答案将被视作正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stations = [1,2,3,4,5,6,7,8,9,10], k = 9
 * 输出：0.50000
 * <p>
 * 示例 2：
 * <p>
 * 输入：stations = [23,24,36,39,46,56,57,65,84,98], k = 1
 * 输出：14.00000
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 10 <= stations.length <= 2000
 * 0 <= stations[i] <= 108
 * stations 按 严格递增 顺序排列
 * 1 <= k <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-max-distance-to-gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class MinimizeMaxDistanceToGasStation {
    /**
     * 先求出所有station之间的距离
     * 然后把最大station间距车站中间插入一个加油站
     * 减半后如果分隔出的两个station之前距离不再是最大，则继续迭代分隔新的最大距离
     * 如果分割出的两个仍是最大，则尝试把插入两个加油站(错误）
     *
     *
     * @param stations
     * @param K
     * @return
     */
    public double minmaxGasDist(int[] stations, int K) {
        double lo = 0, hi = 1e8;
        while (hi - lo > 1e-6) {
            double mi = (lo + hi) / 2.0;
            if (possible(mi, stations, K))
                hi = mi;
            else
                lo = mi;
        }
        return lo;
    }

    public boolean possible(double D, int[] stations, int K) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; ++i)
            used += (int) ((stations[i+1] - stations[i]) / D);
        return used <= K;
    }


    public static void main(String[] args) {
        MinimizeMaxDistanceToGasStation station = new MinimizeMaxDistanceToGasStation();
        System.out.println(station.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        System.out.println(station.minmaxGasDist(new int[]{23,24,36,39,46,56,57,65,84,98}, 1));
        System.out.println(station.minmaxGasDist(new int[]{10,19,25,27,56,63,70,87,96,97}, 3));
    }
}

