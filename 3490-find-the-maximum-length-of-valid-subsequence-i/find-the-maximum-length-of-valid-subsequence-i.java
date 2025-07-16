class Solution {
    public int maximumLength(int[] nums) {
        int countEven = 0;
        int countOdd = 0;
        int alternating = 1;
        int n = nums.length;

        for (int num : nums) {
            if ((num % 2) == 0) {
                countEven++;
            }
            else {
                countOdd++;
            }
        }

        int parity = (nums[0] % 2);
        for (int i = 1; i < n; i++) {
            int currParity = (nums[i] % 2);
            if (parity != currParity) {
                parity = currParity;
                alternating++;
            }
        }

        return Math.max(alternating, Math.max(countEven, countOdd));
    }
}