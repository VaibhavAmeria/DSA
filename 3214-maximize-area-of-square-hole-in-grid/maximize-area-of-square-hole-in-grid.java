class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsHBars = 0;
        int consHBars = -1;
        for (int i = 0; i < hBars.length; i++) {
            if (consHBars != -1 && hBars[i-1]+1 == hBars[i]) {
                consHBars++;
            }
            else {
                consHBars = 1;
            }
            maxConsHBars = Math.max(maxConsHBars, consHBars+1);
        }

        int maxConsVBars = 0;
        int consVBars = -1;
        for (int i = 0; i < vBars.length; i++) {
            if (consVBars != -1 && vBars[i-1]+1 == vBars[i]) {
                consVBars++;
            }
            else {
                consVBars = 1;
            }
            maxConsVBars = Math.max(maxConsVBars, consVBars+1);
        }
        
        int minSide = Math.min(maxConsVBars, maxConsHBars);
        return minSide * minSide;
    }
}