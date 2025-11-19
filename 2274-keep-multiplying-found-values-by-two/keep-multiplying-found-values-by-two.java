class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num < original) {
                continue;
            }
            else if (num == original) {
                original *= 2;
            }
            else {
                break;
            }
        }
        return original;
    }
}