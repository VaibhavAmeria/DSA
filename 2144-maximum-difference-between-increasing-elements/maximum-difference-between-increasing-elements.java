class Solution {
    public int maximumDifference(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            maxDiff = Math.max(maxDiff, nums[i] - smallest);
            System.out.println("smallest -> " + smallest);
            System.out.println("maxDiff -> " + maxDiff);
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }
}