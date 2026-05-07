class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int [] leftMax = new int [n];
        int [] minRight = new int [n];
        int [] ans = new int [n];

        // Handle first element
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);
        }

        minRight[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], nums[i]);
        }

        ans[n-1] = leftMax[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (leftMax[i] <= minRight[i+1]) {
                ans[i] = leftMax[i];
            }
            else {
                ans[i] = ans[i+1];
            }
        }

        return ans;
    }
}