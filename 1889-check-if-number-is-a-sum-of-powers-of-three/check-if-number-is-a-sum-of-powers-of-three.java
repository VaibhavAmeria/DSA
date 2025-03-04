class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Simulation
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int j = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        while(j < n) {
            nums[j] = 0;
            j++;
        }

        return nums;
    }

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
