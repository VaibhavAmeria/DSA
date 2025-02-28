class Solution {
    int [][] dp; 
    int lcs (int i, int j, String str1, String str2) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + lcs (i-1, j-1, str1, str2);
        }
        else {
            dp[i][j] = Math.max(lcs (i-1, j, str1, str2), lcs (i, j-1, str1, str2));
        }
        return dp[i][j];
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        dp = new int [n+1][m+1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }

        StringBuilder sb = new StringBuilder();
        int i = n-1;
        int j = m-1;
        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i--;
                j--;
            }
            else if (lcs(i-1, j, str1, str2) > lcs(i, j-1, str1, str2)) {
                sb.append(str1.charAt(i));
                i--;
            }
            else {
                sb.append(str2.charAt(j));
                j--;
            }
        }
        while (i >= 0) {
            sb.append(str1.charAt(i));
            i--;
        }
        while (j >= 0) {
            sb.append(str2.charAt(j));
            j--;
        }
        return sb.reverse().toString();
    }
}