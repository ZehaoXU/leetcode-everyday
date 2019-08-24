/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class SolutionFirst {
    /**
     * 动态规划，dp[i]表示以i结尾的和最大字串
     * 时间复杂度 O(n), 空间复杂度 O(1) (没有建立dp表，遍历一次即可)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 87.06 % of java submissions (38.4 MB)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int cursum = nums[0];
        for (int i = 1; i < nums.length; i++){
            cursum = cursum>0 ? cursum + nums[i] : nums[i];
            maxsum = Math.max(cursum, maxsum);
        }
        return maxsum;
    }
}

class Solution {
    /**
     * 线性dp，记录i结尾的max subarray，同步刷新最大值。由于只和前一个值有关，所以可以压缩空间
     * TC O(n); SC O(1)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 99.06 % of java submissions (37.6 MB)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int prevMax = nums[0];
        int res = prevMax;
        for (int i = 1; i < n; i++) {
            int currMax = nums[i];
            if (prevMax > 0)
                currMax += prevMax;
            if (currMax > res)  res = currMax;
            prevMax = currMax;
        }
        return res;
    }
}

