class Solution {
    int n;
    int soln (int [] dp, int [] nums, int i) {
        int count = 0;
        if (i >= n) {
            return count;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int take = nums[i] + soln (dp, nums, i+2);
        int skip = soln (dp, nums, i+1);
        return dp[i] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        n = nums.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return soln (dp, nums, 0);
    }
}