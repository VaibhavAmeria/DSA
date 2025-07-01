class Solution {
    public int possibleStringCount(String word) {
        int count = 0;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }

        return count + 1; // +1 for the base case (no long presses)
    }
}