class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;
        for (int i = 1; i < 2*n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i%n] - nums[(i-1)%n]));
        }
        return maxDiff;
    }
}