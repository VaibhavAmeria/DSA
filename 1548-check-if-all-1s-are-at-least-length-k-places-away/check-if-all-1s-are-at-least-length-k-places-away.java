class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastOnesPos = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                if (lastOnesPos != -1 && (i - lastOnesPos <= k)){
                    return false;
                }
                lastOnesPos = i;
            }
        }
        return true;
    }
}