class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int n = points.length;
        for (int i = 1; i < n; i++) {
            int minXAxis = Math.abs(points[i][0] - points[i-1][0]);
            int minYAxis = Math.abs(points[i][1] - points[i-1][1]);

            time += Math.max(minXAxis, minYAxis);
        }
        return time;
    }
}