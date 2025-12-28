class Solution {
    int n;
    int soln (int [] dp, int [] cost, int i) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        // Key fix: You MUST pay cost[i] to step here, THEN decide next jump
        int take1 = cost[i] + soln(dp, cost, i+1);  // Step on i, jump to i+1
        int take2 = cost[i] + soln(dp, cost, i+2);  // Step on i, jump to i+2  
        return dp[i] = Math.min(take1, take2);
    }
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(soln(dp, cost, 0), soln(dp, cost, 1));

    }
}