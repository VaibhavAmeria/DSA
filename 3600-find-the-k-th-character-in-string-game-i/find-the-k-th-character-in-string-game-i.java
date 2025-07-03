class Solution {
    public char kthCharacter(int k) {
        String s = "a";

        while (s.length() < k) {
            // length of s before append
            int n = s.length(); // 1
            for (int i = 0; i < n; i++) {
                s += (char) (s.charAt(i) + 1);
            }   
        }
        return s.charAt(k-1);
    }
}