import java.util.Arrays;

class Solution {
    int n;
    int m;
    int[][] dp;

    int soln(int i, int j, String word1, String word2) {
        // Base case: if we've reached the end of word1
        if (i == n) {
            return m - j; // All remaining characters in word2 need to be inserted
        }
        // Base case: if we've reached the end of word2
        if (j == m) {
            return n - i; // All remaining characters in word1 need to be deleted
        }
        // Check if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match, move to the next character in both strings
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = soln(i + 1, j + 1, word1, word2);
        } else {
            // Calculate costs for replace, delete, and insert operations
            int replace = 1 + soln(i + 1, j + 1, word1, word2); // Replace
            int delete = 1 + soln(i + 1, j, word1, word2);      // Delete
            int insert = 1 + soln(i, j + 1, word1, word2);      // Insert
            dp[i][j] = Math.min(replace, Math.min(delete, insert));
        }
        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new int[n + 1][m + 1];

        // Initialize dp array with -1
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return soln(0, 0, word1, word2);
    }
}
