import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Create a min-heap to store the values and their original indices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Add elements to the min-heap along with their indices
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Prepare to store the result
        int[] res = new int[k];
        List<Integer> indices = new ArrayList<>();
        
        // Retrieve the indices from the min-heap
        while (!minHeap.isEmpty()) {
            int index = minHeap.poll()[1];
            System.out.print(index);
            indices.add(index); // Get the index of the element
        }

        // Sort the indices to maintain the original order in the result
        Collections.sort(indices);
        
        // Populate the result array using the sorted indices
        for (int j = 0; j < k; j++) { // Changed variable name to j to avoid conflict
            res[j] = nums[indices.get(j)];
        }
        
        return res;
    }
}
