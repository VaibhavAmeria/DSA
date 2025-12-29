class Solution {
    int [] dp;
    int soln (int [] nums, int n, int idx) {
        if (idx >= n-1) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < n) {
                int jumps = soln(nums, n, idx + i);
                if (jumps != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, jumps + 1);
                }
            }
        }
        return dp[idx] = minJumps;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        dp = new int [n+1];
        Arrays.fill(dp, -1);
        return soln (nums, n, 0);
    }
}