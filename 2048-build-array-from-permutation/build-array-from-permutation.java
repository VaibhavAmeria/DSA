class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // (n * nums[nums[i]] % n) helps to retrive original value
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0; i < n; i++) {
            // helps to retrive (has to swap with) value
            nums[i] = nums[i] / n;
        }
        return nums;
    }
}