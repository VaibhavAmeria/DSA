class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, current = 0;
        
        for (int diff : differences) {
            current += diff;
            min = Math.min(min, current);
            max = Math.max(max, current);
        }
        
        // Calculate the range of valid starting points
        long validStartMin = lower - min;
        long validStartMax = upper - max;
        
        // The number of valid starting points is the range of valid starts
        return (int) Math.max(0, validStartMax - validStartMin + 1);
    }
}
