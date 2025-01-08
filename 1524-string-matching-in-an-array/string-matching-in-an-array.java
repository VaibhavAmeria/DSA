class Solution {
    int [] computeLPS (String pat) {
        int n = pat.length();
        int [] lps = new int [n];
        lps[0] = 0;
        int len = 0;
        for (int i = 1; i < n; i++) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
            }
            else {
                if (len != 0) {
                    len = lps[len-1];
                }
                else {
                    len = 0;
                }
            }
        }
        return lps;
    }
    boolean searchKMP (String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        int [] lps = computeLPS(pat);

        int i = 0; // txt crawl
        int j = 0; // pat crawl
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                return true;
            }
            else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList <>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && searchKMP(words[j], words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}