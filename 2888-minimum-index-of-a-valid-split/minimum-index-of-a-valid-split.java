class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map <Integer, Integer> map = new HashMap <>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majorityElement = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                majorityElement = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        if (maxCount <= n / 2) {
            return -1;
        }

        int currCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            // map1.put(num, map1.getOrDefault(num, 0) + 1);
            // map2.put(num, map2.getOrDefault(num, 0) - 1);

            if (num == majorityElement) {
                currCount += 1;
            }

            int n1 = i + 1;
            int n2 = n - i - 1;
            int leftCount = currCount;
            int rightCount = maxCount - currCount;
            if (leftCount > n1/2 &&  rightCount > n2/2) {
                return i;
            }
        }
        return -1;
    }
}