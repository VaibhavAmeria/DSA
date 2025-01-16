class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums1) {
            mp.put(num, mp.getOrDefault(num, 0) + n);
        }

        for(int num : nums2) {
            mp.put(num, mp.getOrDefault(num, 0) + m);
        }

        int result = 0;
        for(int num : mp.keySet()) {
            if(mp.get(num) % 2 != 0) {
                result ^= num;
            }
        }

        return result;

    }
}