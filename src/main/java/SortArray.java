import java.util.Arrays;
import java.util.Random;

/**
 * @author likuan
 */
public class SortArray {

    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSort(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int p = new Random().nextInt(end - start + 1) + start;
        swap(nums, start, p);
        p = start;
        for (int i = start + 1, j = end; i <= j; i++) {
            while (i <= j && nums[j] >= nums[p]) j--;
            if (i <= j) {
                swap(nums, j, p);
                p = j;
            }
            while (i <= j && nums[i] < nums[p]) i++;
            if (i <= j) {
                swap(nums, i, p);
                p = i;
            }
        }
        quickSort(start, p - 1, nums);
        quickSort(p + 1, end, nums);
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        SortArray sort = new SortArray();
        System.out.println(Arrays.toString(sort.sortArray(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sort.sortArray(new int[]{})));
        System.out.println(Arrays.toString(sort.sortArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(sort.sortArray(new int[]{0})));
    }
}
