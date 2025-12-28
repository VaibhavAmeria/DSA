class Solution {
    int soln (int [] dp, int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        return dp[i] = soln(dp, i-1) + soln(dp, i-2);
    }
    public int climbStairs(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp, -1);
        return soln (dp, n);
    }
}