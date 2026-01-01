class Solution {
    int n;
    int m;
    int [][] dp;
    int soln (int i, int j, String word1, String word2) {
        if (i == n) {
            // whole string needs to be replaced
            return m-j;
        }
        if (j == m) {
            // whole string needs to be replaced
            return n-i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = soln (i+1, j+1, word1, word2);
        }
        else {
            int replace = 1 + soln (i+1, j+1, word1, word2);
            int delete = 1 + soln (i+1, j, word1, word2);
            int insert = 1 + soln (i, j+1, word1, word2);
            dp[i][j] = Math.min(replace, Math.min(delete, insert));
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new int [n+1][m+1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return soln(0, 0, word1, word2);
    }
}