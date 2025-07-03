class Solution {
    public char kthCharacter(int k) {
        int characterIndex = k-1; // originally at k-1 index in final string
        // count no of setBits
        int setBits = Integer.bitCount(characterIndex);
        return (char) ('a' + setBits);
    }
}