class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        boolean [][] visited = new boolean [n][m];
        int [][] heights = new int [n][m];
        Queue <int []> queue = new LinkedList <>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int [] {i, j});
                    visited[i][j] = true;
                    heights[i][j] =
                    0;
                }
                else {
                    heights[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int [] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int [] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    heights[newX][newY] = (heights[x][y] + 1);
                    visited[newX][newY] = true;
                    queue.add(new int [] {newX, newY});
                }
            }
        }
        return heights;
    }
}