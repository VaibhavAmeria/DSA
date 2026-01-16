class Solution {
    private static final int M = 1_000_000_007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set <Integer> hFenceSet = new HashSet <>();
        Set <Integer> vFenceSet = new HashSet <>();

        int[] newHFences = new int[hFences.length + 2];
        // Copy existing elements to the new array
        for (int i = 0; i < hFences.length; i++) {
            newHFences[i] = hFences[i];
        }
        newHFences[newHFences.length-2] = 1;
        newHFences[newHFences.length-1] = m;

        int[] newVFences = new int[vFences.length + 2];
        // Copy existing elements to the new array
        for (int i = 0; i < vFences.length; i++) {
            newVFences[i] = vFences[i];
        }
        newVFences[newVFences.length-2] = 1;
        newVFences[newVFences.length-1] = n;

        Arrays.sort(newHFences);
        Arrays.sort(newVFences);

        int maxSide = 0;
        for (int i = 0; i < newVFences.length; i++) {
            for (int j = i+1; j < newVFences.length; j++) {
                int diff = newVFences[j] - newVFences[i];
                vFenceSet.add(diff);
            }
        }

        for (int i = 0; i < newHFences.length; i++) {
            for (int j = i+1; j < newHFences.length; j++) {
                int diff = newHFences[j] - newHFences[i];
                if (vFenceSet.contains(diff)) {
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }

        if (maxSide == 0) 
            return -1;

        long area = (long) maxSide * maxSide;
        return (int) (area % M);
    }
}