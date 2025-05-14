class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String s = "11";
        for (int i = 3; i <= n; i++) {
            String t = "";
            int count = 1;
            s += "&"; // Adding a delimiter at the end to handle the last character count
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j-1)) {
                    t += Integer.toString(count);
                    t += s.charAt(j-1);
                    count = 1;
                } else {
                    count++;
                }
            }
            s = t;
        }
        return s;
    }
}
