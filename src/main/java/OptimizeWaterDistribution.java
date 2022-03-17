import java.util.*;

/**
 * 村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
 * <p>
 * 对于每个房子 i，我们有两种可选的供水方案：
 * <p>
 * 一种是直接在房子内建造水井，成本为 wells[i]；
 * 另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，其中每个 pipes[i] = [house1, house2, cost] 代表用管道将 house1 和 house2 连接在一起的成本。当然，连接是双向的。
 * <p>
 * 请你帮忙计算为所有房子都供水的最低总成本。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * 输出：3
 * 解释：
 * 上图展示了铺设管道连接房屋的成本。
 * 最好的策略是在第一个房子里建造水井（成本为 1），然后将其他房子铺设管道连起来（成本为 2），所以总成本为 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, wells = [1,1], pipes = [[1,2,1]]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/optimize-water-distribution-in-a-village
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class OptimizeWaterDistribution {

    /**
     * kruskal 算法
     * @param n
     * @param wells
     * @param pipes
     * @return
     */
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[] root = new int[n + 1];
        List<int[]> pipeList = new ArrayList<>(pipes.length + wells.length);
        pipeList.addAll(Arrays.asList(pipes));
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < wells.length; i++) {
            pipeList.add(new int[]{0, i + 1, wells[i]});
        }
        Collections.sort(pipeList, Comparator.comparingInt(o -> o[2]));

        int sum = 0, num = 0;
        for (int[] ints : pipeList) {
            if (num == n)
                break;

            if (father(ints[0], root) != father(ints[1], root)) {
                num++;
                sum += ints[2];
                root[father(ints[1], root)] = father(ints[0], root);
            }
        }

        return sum;
    }

    private int father(int x, int[] root) {
        if (root[x] != x) {
            int f = father(root[x], root);
            root[x] = f;
            return f;
        }
        return x;

    }

    public static void main(String[] args) {
        OptimizeWaterDistribution waterDistribution = new OptimizeWaterDistribution();
        System.out.println(waterDistribution.minCostToSupplyWater(2, new int[]{1, 1}, new int[][]{new int[]{1, 2, 1}}));
        System.out.println(waterDistribution.minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{new int[]{1, 2, 1}, {2, 3, 1}}));
    }
}
