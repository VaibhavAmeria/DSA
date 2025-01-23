class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [] rows = new int [n];
        int [] cols = new int [m];

        List <int []> ls = new ArrayList <>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                    ls.add(new int [] {i, j});
                }
            }
        }
        int res = 0;
        for (int [] server : ls) {
            if (rows[server[0]] > 1 || cols[server[1]] > 1) {
                res++;
            }
        }
        return res;
    }
}