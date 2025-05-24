class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean canBeZero = true;
        for (int num : nums) {
            if (num != 0) {
                canBeZero = false;
                break;
            }
        }
        if (canBeZero) {
            return 0; // Return 0 if all elements are already zero
        }
        int l = 0;
        int r = m-1;
        int[] prevState = new int[n];
        while (l <= r) {
            int mid = l + (r-l)/2;
            int[] range = Arrays.copyOf(prevState, n);
            // Apply all queries from 0 to mid
            for (int i = 0; i <= mid; i++) {
                int[] query = queries[i];
                range[query[0]] -= query[2];
                if (query[1] + 1 < n) {
                    range[query[1] + 1] += query[2];
                }
            }
            // Calculate cumulative sums
            int cumSum = 0;
            for (int i = 0; i < n; i++) {
                cumSum += range[i];
                range[i] = cumSum;
            }
            // Check if all elements can be made zero
            canBeZero  = true;
            for (int i = 0; i < n; i++) {
                if (nums[i] + range[i] > 0) {
                    canBeZero  = false;
                    break;
                }
            }
            if (canBeZero) {
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return l == m ? -1 : l + 1; 
    }
}
