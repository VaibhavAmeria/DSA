class Solution {
    int [][] dp;
    int solve (int [] values, int i, int j) {
        if (j-i+1 < 3) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            int wt = (values[i] * values[j] * values[k]) + 
                     solve(values, i, k) + 
                     solve(values, k, j);

            result = Math.min(result, wt);
        }
        return dp[i][j] = result;
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int [51][51];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        } 
        return solve (values, 0, n-1);   
    }
}