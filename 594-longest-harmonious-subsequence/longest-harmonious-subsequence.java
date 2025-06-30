class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
        }

        Integer[] keys = treeMap.keySet().toArray(new Integer[0]);
        int length = 0;
        for (int i = 0; i < keys.length; i++) {
            if (i != 0 && (keys[i] - keys[i-1] == 1)) {
                length = Math.max(length, treeMap.get(keys[i]) + treeMap.get(keys[i-1]));
            }
        }
        return length;
    }
}