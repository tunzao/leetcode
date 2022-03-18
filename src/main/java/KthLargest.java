/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class KthLargest {

    /**
     * 堆排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    /**
     * 从第一个非叶子结点（heapSize-1)/2开始构建
     * i 的父节点为 (i-1)/2
     * i 的左子节点为 i*2+1, 右子节点为 i*2+2
     * @param nums
     * @param heapSize
     */
    void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = (heapSize-1) / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    /**
     * 调整堆
     * @param nums
     * @param i
     * @param heapSize
     */
    private void maxHeapify(int[] nums, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = left + 1;
        int largest = i;
        if (left < heapSize && nums[left] > nums[i]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (i != largest) {
            swap(nums, largest, i);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
