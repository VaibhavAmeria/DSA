class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map <Integer, Integer> hsh = new HashMap <>();
        int maxFreq = 0;
        int elementsWithMaxFreq = 0;
        for (int i : nums) {
            int currentFreq = hsh.getOrDefault(i, 0) + 1;
            hsh.put(i, currentFreq);
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                elementsWithMaxFreq = 1;
            }
            else if (currentFreq == maxFreq){
                elementsWithMaxFreq++;
            }
        }
        return elementsWithMaxFreq*maxFreq;
    }
}