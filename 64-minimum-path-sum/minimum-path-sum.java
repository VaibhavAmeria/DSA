class Solution {
    int [][] dp; // Memoization table
    int n; // Number of rows
    int m; // Number of columns 

    // Recursive function to calculate the minimum path sum
    int soln (int i, int j, int [][] grid) {
        // Base case: if out of bounds, return 0
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        // Base case: if at the bottom-right corner, return the cell's value
        if (i == n-1 && j == m-1) {
            return grid[i][j];
        }
        // Check if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Compute the minimum path sum from the current cell
        return dp[i][j] = grid[i][j] + Math.min(soln(i, j+1, grid), soln(i+1, j, grid));
    }

    // Main function to initialize variables and start the recursion
    public int minPathSum(int[][] grid) {
        n = grid.length; // Set number of rows
        m = grid[0].length; // Set number of columns
        dp = new int[n][m]; // Initialize the memoization table
        // Fill the dp array with -1 to indicate uncomputed states
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return soln(0, 0, grid); // Start from the top-left corner
    }
}
