class Solution {
    boolean getPairs (int [] nums, int value, int p, int n) {
        int count = 0;
        int i = 0;
        while (i < n-1) {
            if ((nums[i+1] - nums[i]) <= value) {
                count++;
                i++;
            }
            if (count >= p) {
                return true;
            }
            i++;
        }
        return false;
    }
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);

        int maxDiff = nums[n-1] - nums[0];
        int result = Integer.MAX_VALUE;
        int l = 0;
        int r = maxDiff;
        while (l <= r) {
            int mid = l+(r-l)/2;
            if (getPairs(nums, mid, p, n)) {
                result = Math.min(result, mid);
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return result;
    }
}