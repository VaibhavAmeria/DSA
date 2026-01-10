class Solution {
    int n;
    int m;
    int [][] dp;
    public int sum (String s, int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += s.charAt(i);
        }
        return total;
    }
    int soln (int i, int j, String s1, String s2) {
        if (i >= n) {
            return sum(s2, j, m-1);
        }
        if (j >= m) {
            return sum(s1, i, n-1);
        }

        // Check memoization
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = soln (i+1, j+1, s1, s2);
        }
        else {
            int include = s1.charAt(i) + soln (i+1, j, s1, s2);
            int exclude = s2.charAt(j) + soln (i, j+1, s1, s2);

            dp[i][j] = Math.min(include, exclude);
        }

        return dp[i][j];
    }
    public int minimumDeleteSum(String s1, String s2) {
        n = s1.length();
        m = s2.length();
        dp = new int [n+1][m+1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return soln(0, 0, s1, s2);
    }
}