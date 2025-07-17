class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        // mod can be 0 to k-1
        int [][] dp = new int [k][n];
        for (int [] arr : dp) {
            Arrays.fill(arr, 1);
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[mod][i] = Math.max(dp[mod][i], dp[mod][j] + 1);
                res = Math.max(res, dp[mod][i]);
            }
        }
        return res;
    }
}