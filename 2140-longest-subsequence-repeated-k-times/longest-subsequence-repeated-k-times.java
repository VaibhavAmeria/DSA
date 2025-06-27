class Solution {
    String res = "";

    boolean isSubsequence (String s, String curr, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = curr.length();
        while (i < n && j < m*k) {
            if (s.charAt(i) == curr.charAt(j%m)) {
                j++;
            }
            i++;
        }

        return j == m*k;
    }

    void backtracking (String s, StringBuilder curr, boolean [] canUse, int [] requiredFreq, int k, int maxLen) {
        if (curr.length() > maxLen) {
            return;
        }

        String currStr = curr.toString();
        if ((curr.length() > res.length() || (curr.length() == res.length() && currStr.compareTo(res) > 0)) && isSubsequence(s, currStr, k)) {
            res = currStr;
        }

        for (int i = 25; i >= 0; i--) { // from 'z' to 'a' for lexicographically larger result
            if (!canUse[i] || requiredFreq[i] == 0) continue;

            curr.append((char) (i + 'a'));
            requiredFreq[i]--;

            backtracking(s, curr, canUse, requiredFreq, k, maxLen);

            curr.deleteCharAt(curr.length() - 1);
            requiredFreq[i]++;
        }

    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int [] freq = new int [26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int n = s.length();
        boolean [] canUse = new boolean [26];
        int [] requiredFreq = new int [26];
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                canUse[i] = true;
                requiredFreq[i] = freq[i]/k; // max freq used in subsequence
            }
        }

        int maxLen = n / k;
        StringBuilder curr = new StringBuilder ();
        backtracking(s, curr, canUse, requiredFreq, k, maxLen);
        return res;
    }
}