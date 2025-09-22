class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map <Integer, Integer> hsh = new HashMap <>();
        int maxFreq = 0;
        for (int i : nums) {
            hsh.put(i, hsh.getOrDefault(i, 0) + 1);
            maxFreq = Math.max(maxFreq, hsh.get(i));
        }

        int elementsWithMaxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : hsh.entrySet()) {
            if (entry.getValue() == maxFreq) {
                elementsWithMaxFreq += maxFreq;
            }
        }
        // System.out.print(elementsWithMaxFreq);
        return elementsWithMaxFreq;
    }
}