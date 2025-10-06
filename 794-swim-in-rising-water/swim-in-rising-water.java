class Solution {
    // want to find max value in minimum path
    // apply binary search on ans
    int n;
    int m;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean possibleToReach (int [][] grid, int i, int j, int t, boolean [][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] == true || grid[i][j] > t) {
            return false;
        }

        if (i == n-1 && j == m-1) {
            return true;
        }

        visited[i][j] = true;
        for (int [] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (possibleToReach(grid, newI, newJ, t, visited)) {
                return true;
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int l = 0;
        int r = (n*n)-1;
        int result = 0;

        while (l <= r) {
            int mid = l+(r-l)/2;
            boolean [][] visited = new boolean [n][m];
            if (possibleToReach(grid, 0, 0, mid, visited)) {
                result = mid;
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return result;
    }
}