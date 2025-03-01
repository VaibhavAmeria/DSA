class Solution {
    public int[] applyOperations(int[] nums) {
        // First pass: apply operations
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2; // Double the current number
                nums[i + 1] = 0; // Set the next number to zero
            }
        }

        // Second pass: compact the array
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                result[index++] = num; // Add non-zero numbers to result
            }
        }

        // Fill the rest of the result array with zeros
        while (index < result.length) {
            result[index++] = 0;
        }

        return result; // Return the final result array
    }
}
