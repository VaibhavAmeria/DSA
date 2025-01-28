class Solution {
    private int n, m;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 0;
        }

        int fishCount = grid[x][y];
        grid[x][y] = 0; // Mark this cell as visited (fish collected)

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            fishCount += dfs(newX, newY, grid);
        }

        return fishCount;
    }

    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int maxFish = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) { // Fish cell found
                    maxFish = Math.max(maxFish, dfs(i, j, grid));
                }
            }
        }

        return maxFish;
    }
}