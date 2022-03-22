/**
 * @author likuan
 */
public class LongestIncreasingSubsequence {

    /**
     * 动态规划
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] =1;
        int maxans = 1;
        for (int i=1; i<nums.length;i++) {
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            maxans = Math.max(dp[i], maxans);
        }
        return maxans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence incr = new LongestIncreasingSubsequence();
        System.out.println(incr.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(incr.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(incr.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
