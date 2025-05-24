class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;

        // for storing (to be used) queries
        PriorityQueue <Integer> past = new PriorityQueue <>();

        // minHeap for storing to be used again queries for curr nums[i]
        PriorityQueue <Integer> maxHeap = new PriorityQueue <>((a, b) -> b - a);

        // Sort queries by start index
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        int j = 0;               // Pointer to queries
        int usedCount = 0;       // Number of queries used
        for (int i = 0; i < n; i++) {
            while (j < queries.length && queries[j][0] == i) {
                // pushing ending index
                maxHeap.offer(queries[j][1]);
                j++;
            }

            nums[i] -= past.size();
            while (nums[i] > 0 && !maxHeap.isEmpty() && maxHeap.peek() >= i) {
                int r = maxHeap.poll();
                past.offer(r);
                usedCount++;
                nums[i]--;
            }

            if (nums[i] > 0) {
                return -1;
            }

            // Remove expired queries
            while (!past.isEmpty() && past.peek() == i) {
                past.poll();
            }
        }
        return q - usedCount;
    }
}