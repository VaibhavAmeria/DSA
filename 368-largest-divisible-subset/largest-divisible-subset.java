class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int [] dp = new int [n];
        Arrays.fill(dp, 1);
        int [] prevIndex = new int [n];
        Arrays.fill(prevIndex, -1);
        int maxLen = 1;
        int lastChosenIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                        prevIndex[i] = j;
                    }
                    if (dp[i] > maxLen) {
                        maxLen = dp[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List <Integer> res = new ArrayList <>();
        while (lastChosenIndex >= 0) {
            res.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIndex[lastChosenIndex];
        }
        return res;
    }
}