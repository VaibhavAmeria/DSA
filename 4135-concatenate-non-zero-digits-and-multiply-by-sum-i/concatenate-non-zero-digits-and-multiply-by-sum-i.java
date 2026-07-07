class Solution {
    public long sumAndMultiply(int n) {
        String numStr = String.valueOf(n).replace("0", "");

        if (numStr.isEmpty()) {
            return 0;
        }
        
        long sum = numStr.chars()
                    .map(c -> c - '0')
                    .sum();

        // Simply parse once and multiply
        long number = Long.parseLong(numStr);
        return number * sum;  // No need to parse again
    }
}