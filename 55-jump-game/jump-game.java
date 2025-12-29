class Solution {
    int [] dp;
    boolean soln (int [] nums, int n, int idx) {
        if (idx == n-1) {
            return true;
        }
        if (idx >= n && nums[idx] == 0) {
            return false;
        }
        if (dp[idx] != -1) {
            return dp[idx] == 1;
        }

        for (int i = 1; i <= nums[idx]; i++) {
            if (soln (nums, n, idx + i) == true) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new int [n+1];
        Arrays.fill(dp, -1);
        return soln (nums, n, 0);        
    }
}