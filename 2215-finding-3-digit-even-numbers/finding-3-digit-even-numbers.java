class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        int [] freq = new int [10];
        List<Integer> ls = new ArrayList<>();
        for (int i : digits) {
            freq[i]++;
        }

        for (int i = 1; i <= 9; i++) {
            // no leading zeroes for i
            if (freq[i] == 0) {
                continue;
            }
            freq[i]--;
            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0) {
                    continue;
                }
                freq[j]--;
                for (int k = 0; k <= 8; k+=2) {
                    // for having even digit
                    if (freq[k] == 0) {
                        continue;
                    }
                    freq[k]--;
                    int digit = i*100 + j*10 + k*1;
                    ls.add(digit);
                    freq[k]++;
                }
                freq[j]++;
            }
            freq[i]++;
        }

        // Collections.sort(ls);
        int [] res = new int [ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}