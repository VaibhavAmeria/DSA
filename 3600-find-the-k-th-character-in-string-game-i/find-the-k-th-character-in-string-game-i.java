class Solution {
    public char kthCharacter(int k) {
        String s = "a";

        while (s.length() < k) {
            String copy = s;
            for (char ch : copy.toCharArray()) {
                copy += (char) (ch + 1);
            }
            s = copy;
        }
        return s.charAt(k-1);
    }
}