class Solution {
    public static int thueMorseRecursive(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int halfLength = (int) Math.pow(2, n - 2); // Length of S(n-1)
        if (k <= halfLength) {
            return thueMorseRecursive(n - 1, k);
        } else {
            int c = 1 - thueMorseRecursive(n - 1, k - halfLength);
            return c;
        } 
    }
    public int kthGrammar(int n, int k) {
        return thueMorseRecursive(n, k);
    }
}

