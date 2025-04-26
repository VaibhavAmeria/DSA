class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minKPosition = -1;
        int maxKPosition = -1;
        int culpritIndex = -1;
        long ans = 0;
        int n = nums.length;
        boolean sameArray = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == minK) {
                minKPosition = i;
            }
            if (nums[i] == maxK) {
                maxKPosition = i;
            }
            if (nums[i] > maxK || nums[i] < minK) {
                culpritIndex = i;
            }

            int smaller = Math.min(minKPosition, maxKPosition);
            int temp = smaller - culpritIndex;
            ans += temp <= 0 ? 0 : temp;
        }
        return ans;
    }
}
