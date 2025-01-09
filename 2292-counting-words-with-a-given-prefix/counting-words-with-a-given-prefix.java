class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = pref.length();
        int count = 0;
        for (String word : words) {
            if (word.length() >= n && word.substring(0, n).equals(pref)) {
                count++;
            }
        }
        return count;
    }
}