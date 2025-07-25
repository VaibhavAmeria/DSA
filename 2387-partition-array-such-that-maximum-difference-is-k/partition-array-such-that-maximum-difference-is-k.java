class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int numberToJump = nums[i] + k;
            while (i < n && nums[i] <= numberToJump) {
                i++;
            }
            count++;
            i -= 1;
        }
        return count;
    }
}