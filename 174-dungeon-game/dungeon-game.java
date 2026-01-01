class Solution {
    int n;
    int m;
    int [][] dp;
    int soln (int i, int j, int [][] grid) {
        if (i == n-1 && j == m-1) {
            // minimum health before entering last cell
            return dp[i][j] = Math.max(1, 1 - grid[i][j]);
        }
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minHealthNeededNext = Math.min(soln(i+1, j, grid), soln(i, j+1, grid));
        return dp[i][j] = Math.max(1, minHealthNeededNext - grid[i][j]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;
        dp = new int [n+1][m+1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return soln (0, 0, dungeon);
    }
}