class Solution {
    int [][] dp;
    int n;
    int m;
    int soln (int i, int j, int [][] grid) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (i == n-1 && j == m-1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = grid[i][j] + Math.min(soln(i, j+1, grid), soln(i+1, j, grid));
    }
    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return soln(0, 0, grid);
    }
}
