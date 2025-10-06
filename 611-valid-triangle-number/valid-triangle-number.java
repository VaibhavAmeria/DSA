class Solution {
    int binarySearchOnRestArray (int l, int r, int target, int [] nums) {
        int k = -1;
        while (l <= r) {
            int mid = l+(r-l)/2;
            if (nums[mid] < target) {
                k = mid;
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return k;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int possibleTriangles = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i+1; j < n; j++) {
                int sum = nums[i] + nums[j];
                // apply binary search on j+1 to n array to find maxBound element
                int k = binarySearchOnRestArray(j, n-1, sum, nums);
                if (k != -1) {
                    possibleTriangles += k-j;
                }
            }
        }
        return possibleTriangles;
    }
}