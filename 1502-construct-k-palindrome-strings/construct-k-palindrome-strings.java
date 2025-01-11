class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) {
            return true;
        }
        if (n < k) {
            return false;
        }

        HashMap <Character, Integer> hsh = new HashMap <>();
        for (char ch : s.toCharArray()) {
            hsh.put(ch, hsh.getOrDefault(ch, 0) + 1);
        }

        int oddFreq = 0;
        for (char key : hsh.keySet()) {
            if (hsh.get(key) % 2 != 0) {
                oddFreq++;
            }
        }

        if (oddFreq <= k) {
            return true;
        }
        else {
            return false;
        }
    }
}