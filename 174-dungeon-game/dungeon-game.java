class Solution {
    int n;
    int m;
    int [][] dp;

    // soln(i, j) = minimum health required BEFORE entering cell (i, j)
    // so that the knight can reach the princess alive from there
    int soln (int i, int j, int [][] grid) {

        // 1) Base case: we are at the bottom-right (princess's cell)
        if (i == n-1 && j == m-1) {
            // After entering this cell, health_change = grid[i][j].
            // Let H = health before entering this cell.
            // We need H + grid[i][j] >= 1  =>  H >= 1 - grid[i][j].
            // Also health must be at least 1.
            // So minimum H = max(1, 1 - grid[i][j]).
            return dp[i][j] = Math.max(1, 1 - grid[i][j]);
        }

        // 2) If we go outside the grid, this path is invalid.
        // Use a very large value so that this direction is never chosen
        // in the min() call.
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        // 3) If already computed, just reuse the value (memoization).
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // 4) From (i, j) we can go either:
        //    - Down  to (i+1, j)
        //    - Right to (i, j+1)
        // Each of those cells has its own "minimum health required before entering".
        int minHealthNeededNext = Math.min(
            soln(i+1, j, grid),   // health needed if we go DOWN
            soln(i, j+1, grid)    // health needed if we go RIGHT
        );

        // 5) Let H = health required BEFORE entering (i, j).
        // After entering (i, j), health becomes H + grid[i][j].
        // That must be at least minHealthNeededNext (so that we can safely
        // move to the next cell), i.e.:
        //      H + grid[i][j] >= minHealthNeededNext
        //  =>  H >= minHealthNeededNext - grid[i][j]
        //
        // Also, at any cell, health must be at least 1.
        // So:
        //      H = max(1, minHealthNeededNext - grid[i][j])
        return dp[i][j] = Math.max(1, minHealthNeededNext - grid[i][j]);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;

        // dp[i][j] = minimum health required BEFORE entering (i, j)
        // Initialize with -1 to indicate "not computed yet".
        dp = new int [n+1][m+1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // We want the minimum health required before entering cell (0, 0).
        return soln (0, 0, dungeon);
    }
}
