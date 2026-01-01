class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int [n][m];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }

        dp[n-1][m-1] = grid[n-1][m-1];

        // fill last row
        for (int i = m-2; i >= 0; i--) {
            dp[n-1][i] = grid[n-1][i] + dp[n-1][i+1];
        }

        // fill last col
        for (int i = n-2; i >= 0; i--) {
            dp[i][m-1] = grid[i][m-1] + dp[i+1][m-1];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}