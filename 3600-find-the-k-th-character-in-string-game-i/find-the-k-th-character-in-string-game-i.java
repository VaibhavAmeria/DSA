class Solution {
    public char kthCharacter(int k) {
        int characterIndex = k-1; // originally at k-1 index in final string

        // count no of setBits
        int setBits = 0;
        while (characterIndex != 0) {
            if ((characterIndex & 1) == 1) {
                setBits++;
            }
            characterIndex = characterIndex >> 1;
        }
        // a is the starting character
        return (char) ('a' + setBits);
    }
}