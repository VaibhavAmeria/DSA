class Solution {
    int [][] merge (int [][] intervals) {
        List <int []> res = new ArrayList <>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= res.get(res.size()-1)[1]) {
                // overlapping
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], intervals[i][1]);
            }
            else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int [res.size()][]);
    }
    public int countDays(int days, int[][] meetings) {
        int [][] occupied = merge(meetings);
        for (int [] arr : occupied) {
            days -= (arr[1] - arr[0] + 1);
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return days;
    }
}