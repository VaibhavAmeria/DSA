class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) {
            return true;
        }
        if (n < k) {
            return false;
        }

        int [] freq = new int [26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddFreq++;
            }
        }

        if (oddFreq <= k) {
            return true;
        }
        else {
            return false;
        }
    }
}