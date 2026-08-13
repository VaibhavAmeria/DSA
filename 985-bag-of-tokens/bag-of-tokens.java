class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int score = 0;
        int maxScore = 0;
        int i = 0;
        int j = n - 1;
        
        while (i <= j) {
            if (power >= tokens[i]) {
                // Play face-up
                power -= tokens[i];
                score++;
                i++;
                maxScore = Math.max(maxScore, score);
            }
            else if (score > 0) {
                // Play face-down (only if we have score to spend)
                power += tokens[j];
                score--;
                j--;
            }
            else {
                // Cannot play either way
                break;
            }
        }
        return maxScore;
    }
}