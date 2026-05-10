class Solution {
    int [] dp;
    int solve (int i, int target, int n, int [] nums) {
        if (i == n-1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int result = Integer.MIN_VALUE;
        for (int j = i+1; j < n; j++) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                int maxSteps = 1 + solve(j, target, n, nums);
                result = Math.max(result, maxSteps);
            }
        }
        return dp[i] = result;
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        dp = new int [n+1];
        Arrays.fill(dp, -1);
        int ans = solve (0, target, n, nums);
        return ans < 0 ? -1 : ans;
    }
}