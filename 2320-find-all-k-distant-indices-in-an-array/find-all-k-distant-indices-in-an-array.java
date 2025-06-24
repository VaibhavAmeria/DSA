class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List <Integer> res = new ArrayList <>();
        int n = nums.length;
        int startingValidIndex = 0;
        int endingValidIndex = nums.length-1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                // valid indices
                int start = Math.max(i - k, 0); // can be negative
                int end = Math.min(i + k, n - 1); // can be greater than n

                // avoid duplicate indices
                if (!res.isEmpty() && res.get(res.size()-1) >= start) {
                    start = res.get(res.size() - 1) + 1;
                }

                for (int j = start; j <= end; j++) {
                    res.add(j);
                }
            }
        }
        return res;
    }
}