import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class ThreeSum {

    /**
     * 「不重复」的本质是什么？我们保持三重循环的大框架不变，只需要保证：
     * <p>
     * 第二重循环枚举到的元素不小于当前第一重循环枚举到的元素；
     * <p>
     * 第三重循环枚举到的元素不小于当前第二重循环枚举到的元素。
     * <p>
     * 也就是说，我们枚举的三元组 (a,b,c)(a, b, c)(a,b,c) 满足 a≤b≤ca \leq b \leq ca≤b≤c，保证了只有 (a,b,c)(a, b, c)(a,b,c) 这个顺序会被枚举到，而 (b,a,c)(b, a, c)(b,a,c)、(c,b,a)(c, b, a)(c,b,a) 等等这些不会，这样就减少了重复。要实现这一点，我们可以将数组中的元素从小到大进行排序，随后使用普通的三重循环就可以满足上面的要求。
     * <p>
     * 同时，对于每一重循环而言，相邻两次枚举的元素不能相同，否则也会造成重复。举个例子，如果排完序的数组为
     * <p>
     * [0, 1, 2, 2, 2, 3]
     * ^  ^  ^
     * <p>
     * 我们使用三重循环枚举到的第一个三元组为 (0,1,2)(0, 1, 2)(0,1,2)，如果第三重循环继续枚举下一个元素，那么仍然是三元组 (0,1,2)(0, 1, 2)(0,1,2)，产生了重复。因此我们需要将第三重循环「跳到」下一个不相同的元素，即数组中的最后一个元素 333，枚举三元组 (0,1,3)(0, 1, 3)(0,1,3)。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int k = nums.length - 1;
                int sum = -nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        while (k > j && (nums[j] + nums[k]) > sum) {
                            k--;
                        }
                        if (k == j) {
                            break;
                        }
                        if (nums[j] + nums[k] == sum) {
                            List<Integer> tri = new ArrayList<>(3);
                            tri.add(nums[i]);
                            tri.add(nums[j]);
                            tri.add(nums[k]);
                            result.add(tri);
                        }
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum.threeSum(new int[]{}));
        System.out.println(threeSum.threeSum(new int[]{0}));
        System.out.println(threeSum.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum.threeSum(new int[]{3, -2, 1, 0}));
    }
}
