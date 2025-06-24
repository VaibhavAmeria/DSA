class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set <Integer> set = new HashSet <>();
        List <Integer> res = new ArrayList <>();
        int n = nums.length;
        int startingValidIndex = 0;
        int endingValidIndex = nums.length-1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                // valid indices
                int start = i - k;
                int end = i + k;
                for (int j = start; j <= end; j++) {
                    if (j >= startingValidIndex && j <= endingValidIndex) {
                        set.add(j);
                    }
                }
            }
        }

        for (int val : set) {
            res.add(val);
        }
        Collections.sort(res);
        return res;
    }
}