import java.util.*;

class Solution {
    int[] getCharacterCount(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        return freq;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ls = new ArrayList<>();
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] currFreq = getCharacterCount(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], currFreq[i]);
            }
        }
        for (String word : words1) {
            int[] currWordFreq = getCharacterCount(word);
            boolean isUniversal = true;

            for (int i = 0; i < 26; i++) {
                if (currWordFreq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                ls.add(word);
            }
        }
        return ls;
    }
}
