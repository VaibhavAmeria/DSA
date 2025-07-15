class Solution {
    public boolean isValid(String word) {
        boolean hasVowel =  false;
        boolean hasConsonent =  false;
        String vowels = "aeiou";
        int n = word.length();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (vowels.contains(String.valueOf(lower))) {
                    hasVowel = true;
                }
                else {
                    hasConsonent = true;
                }
            }
            else if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return (hasVowel && hasConsonent) && (n >= 3);
    }
}