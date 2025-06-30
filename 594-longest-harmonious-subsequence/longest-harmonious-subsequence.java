import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Iterate through the frequency map
        for (int key : frequencyMap.keySet()) {
            // Check if the next number exists (key + 1)
            if (frequencyMap.containsKey(key + 1)) {
                int currentLength = frequencyMap.get(key) + frequencyMap.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
            // Check if the previous number exists (key - 1)
            if (frequencyMap.containsKey(key - 1)) {
                int currentLength = frequencyMap.get(key) + frequencyMap.get(key - 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
