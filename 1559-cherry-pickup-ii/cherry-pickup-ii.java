class Solution {
    int n;
    int m;
    int [][][] dp;
    int soln (int row, int c1, int c2, int [][] grid) {
        if (row >= n) {
            return 0;
        }

        if (dp[row][c1][c2] != -1) {
            return dp[row][c1][c2];
        }

        int chery = grid[row][c1];
        if (c1 != c2) {
            chery += grid[row][c2];
        }

        int ans = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + 1;
                int newCol1 = c1 + i;
                int newCol2 = c2 + j;
                if (newRow < n && newCol1 >= 0 && newCol2 >= 0 && newCol1 < m && newCol2 < m) {
                    ans = Math.max(ans, soln(newRow, newCol1, newCol2, grid));
                }
            }
        }

        return dp[row][c1][c2] = (chery += ans);
    }
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int [n+1][m+1][m+1];dp = new int [n+1][m+1][m+1];
        // Initialize the array with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return soln(0, 0, m-1, grid);
    }
}