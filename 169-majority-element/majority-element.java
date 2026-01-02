class Solution {
    public int majorityElement(int[] nums) {
        int majorityEle = nums[0];   
        int majorityEleCount = 0;
        for (int num : nums) {
            if (majorityEleCount == 0) {
                majorityEle = num;
            }
            if (num == majorityEle) {
                majorityEleCount++;
            }
            else {
                majorityEleCount--;
            }
        }
        return majorityEle;
    }
}