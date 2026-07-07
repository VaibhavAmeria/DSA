class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // if same starting, covering max distance comes first
        // else sorted based on starting index
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            // no need to check arr[0] as it is always smaller or equal bcoz sorted
            if (res.get(res.size()-1)[1] >= intervals[i][1]) {
                continue;
            }
            res.add(intervals[i]);
        }

        return res.size();   
    }
}