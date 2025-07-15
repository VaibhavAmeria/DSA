class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        String vowels = "aeiouAEIOU";
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        String digits = "1234567890";

        boolean hasVowel =  false;
        boolean hasConsonent =  false;
        boolean hasDigit =  false;
        for (char ch : word.toCharArray()) {
            if (!vowels.contains(String.valueOf(ch)) &&
                !consonants.contains(String.valueOf(ch)) &&
                !digits.contains(String.valueOf(ch))) {
                return false; // Found a special character
            }
            if (vowels.contains(String.valueOf(ch))) {
                hasVowel = true;
            }
            if (consonants.contains(String.valueOf(ch))) {
                hasConsonent = true;
            }
        }

        return (hasVowel && hasConsonent) && (n >= 3);
    }
}