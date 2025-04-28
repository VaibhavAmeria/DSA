class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        HashMap <Integer, Long> map = new HashMap <>();
        // 0 -> remainder
        // 1 -> count
        map.put(0, 1L);  
        long result = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) {
                sum += 1;
            }
            int r1 = (int)(sum % modulo);
            int r2 = (r1 - k + modulo) % modulo;

            result += map.getOrDefault(r2, 0L);
            map.put(r1, map.getOrDefault(r1, 0L) + 1);
        }
        return result;
    }
}
