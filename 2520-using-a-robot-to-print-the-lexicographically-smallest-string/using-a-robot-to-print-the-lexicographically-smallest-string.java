class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minRight = new char[n + 1];
        minRight[n] = Character.MAX_VALUE;
        
        // Precompute the smallest character to the right of each position
        for (int i = n - 1; i >= 0; i--) {
            minRight[i] = (char) Math.min(s.charAt(i), minRight[i + 1]);
        }
        
        StringBuilder t = new StringBuilder();
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            t.append(s.charAt(i));
            // While top of t is <= smallest remaining character
            while (t.length() > 0 && t.charAt(t.length() - 1) <= minRight[i + 1]) {
                res.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
        }
        
        // Append remaining characters in t
        while (t.length() > 0) {
            res.append(t.charAt(t.length() - 1));
            t.deleteCharAt(t.length() - 1);
        }
        
        return res.toString();
    }
}