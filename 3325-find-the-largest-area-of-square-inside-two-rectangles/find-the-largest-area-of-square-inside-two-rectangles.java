class Solution {
    private static final int MOD = 1_000_000_007;
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSqPossible = 0L;
        for (int i = 0; i < n; i++) {           
            for (int j = i + 1; j < n; j++) {
                int x1 = Math.min(topRight[i][0], topRight[j][0]);
                int x2 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);

                int y1 = Math.min(topRight[i][1], topRight[j][1]);
                int y2 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                int width = x1 - x2;
                int height = y1 - y2;

                if (width <= 0 || height <= 0) {
                    continue;
                }
                int sideOfSq = Math.min(width, height);
                
                long area = 1L * sideOfSq * sideOfSq;
                
                maxSqPossible = Math.max(maxSqPossible, area);
            }
        }
        return maxSqPossible;
    }
}
