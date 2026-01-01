class Solution {
    int [][] dp;
    int soln (int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        if (i == m-1 && j == n-1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = soln (i+1, j, m, n);
        int bottom = soln (i, j+1, m, n);

        return dp[i][j] = right + bottom;
    }
    public int uniquePaths(int m, int n) {
        dp = new int [m+1][n+1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return soln (0, 0, m, n);   
    }
}