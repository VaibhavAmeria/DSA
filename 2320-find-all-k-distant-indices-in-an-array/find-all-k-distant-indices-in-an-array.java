class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List <Integer> ls = new ArrayList <>();
        List <Integer> res = new ArrayList <>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                ls.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int index : ls) {
                if (Math.abs(i-index) <= k) {
                    res.add(i);
                    break;
                }
            }
        }

        return res;
    }
}