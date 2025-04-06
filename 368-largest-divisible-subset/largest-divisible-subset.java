import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[] memo;
    private int[] prev;
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        memo = new int[n];
        prev = new int[n];
        Arrays.fill(memo, -1); // Initialize memoization array
        Arrays.fill(prev, -1);  // Initialize previous index array

        int maxSize = 0;
        int maxIndex = -1;

        // Calculate the size of the largest divisible subset for each index
        for (int i = 0; i < n; i++) {
            int size = dfs(nums, i);
            if (size > maxSize) {
                maxSize = size;
                maxIndex = i;
            }
        }

        // Reconstruct the largest divisible subset
        List<Integer> res = new ArrayList<>();
        for (int k = maxIndex; k >= 0; k = prev[k]) {
            res.add(nums[k]);
            if (prev[k] == -1) break; // Stop if there are no more predecessors
        }

        // Reverse the result to get the correct order
        Collections.reverse(res);
        return res;
    }

    private int dfs(int[] nums, int index) {
        if (memo[index] != -1) return memo[index]; // Return cached result
        
        int maxSize = 1; // The subset includes the current element itself

        for (int j = 0; j < index; j++) {
            if (nums[index] % nums[j] == 0) {
                int size = 1 + dfs(nums, j); // Include nums[j]
                if (size > maxSize) {
                    maxSize = size;
                    prev[index] = j; // Update predecessor
                }
            }
        }

        memo[index] = maxSize; // Cache the result
        return maxSize;
    }
}
