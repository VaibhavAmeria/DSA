class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        
        int n = word.length();
        char largestChar = word.charAt(0);
        List<Integer> indices = new ArrayList <>();
        
        // Find the rightmost largest character
        for (int i = n-1; i >= 0; i--) {
            if (word.charAt(i) >= largestChar) {
                largestChar = word.charAt(i);
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (word.charAt(i) == largestChar) {
                indices.add(i);
            }
        }

        String res = "";
        int availableChars = n - (numFriends - 1);
        for (int index : indices) {
            int endIndex = Math.min(index + availableChars, n);

            String newString = word.substring(index, endIndex);
            if (res.compareTo(newString) < 0) {
                res = newString;
            }
        }

        return res;
    }
}