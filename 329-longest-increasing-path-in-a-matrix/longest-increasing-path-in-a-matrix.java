class Solution {
    int n;
    int m;
    int [][] dp;
    int dfs (int i, int j, int [][] matrix, int prevVal) {
        if (i < 0 || j < 0 || i >= n || j >= m || matrix[i][j] <= prevVal) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int up = dfs(i-1, j, matrix, matrix[i][j]);
        int down = dfs(i+1, j, matrix, matrix[i][j]);
        int left = dfs(i, j-1, matrix, matrix[i][j]);
        int right = dfs(i, j+1, matrix, matrix[i][j]);

        return dp[i][j] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
    }
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;       
        m = matrix[0].length;
        dp = new int [n+1][m+1];

        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int maxPathLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPathLen = Math.max(maxPathLen, dfs(i, j, matrix, Integer.MIN_VALUE));
            }
        }
        return maxPathLen;
    }
}