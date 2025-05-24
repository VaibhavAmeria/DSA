class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] range = new int [n];
        for (int [] query : queries) {
            range[query[0]] -= 1;
            if (query[1]+1 < n) {
                range[query[1]+1] += 1;
            }
        }

        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += range[i];
            range[i] = cumSum;
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(range[i] + " ");
        // }

        for (int i = 0; i < n; i++) {
            if (nums[i] + range[i] > 0) {
                return false;
            }
        }
        return true;
    }
}