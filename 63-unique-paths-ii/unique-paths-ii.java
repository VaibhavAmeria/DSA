class Solution {
    int n;
    int m;
    int [][] dp;
    int soln (int i, int j, int [][] grid) {
        if (i == n-1 && j == m-1 && grid[i][j] != 1) {
            return 1;
        }
        if (i >= n || j >= m || grid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = soln (i+1, j, grid) + soln(i, j+1, grid);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;
        dp = new int [n+1][m+1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return soln (0, 0, obstacleGrid);
    }
}