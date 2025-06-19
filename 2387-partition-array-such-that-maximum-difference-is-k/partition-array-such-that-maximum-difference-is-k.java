class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int numberToJump = nums[i] + k;
            int j = i;
            while (j < n && nums[j] <= numberToJump) {
                j++;
            }
            if (j > i) {
                count++;
                i = j - 1;
            }
        }
        return count;
    }
}