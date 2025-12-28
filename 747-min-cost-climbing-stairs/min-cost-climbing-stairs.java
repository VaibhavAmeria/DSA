class Solution {
    int n;
    int soln (int [] dp, int [] cost, int i) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int take1 = cost[i] + soln(dp, cost, i+1);
        int take2 = cost[i] + soln(dp, cost, i+2);
        return dp[i] = Math.min(take1, take2);
    }
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(soln(dp, cost, 0), soln(dp, cost, 1));

    }
}