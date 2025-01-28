class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[n][m];
        int maxFish = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    int currSum = 0;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];
                        currSum += grid[x][y];

                        for (int[] dir : directions) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < m 
                                && grid[newX][newY] != 0 && !visited[newX][newY]) {
                                visited[newX][newY] = true;
                                queue.offer(new int[]{newX, newY});
                            }
                        }
                    }
                    maxFish = Math.max(maxFish, currSum);
                }
            }
        }
        return maxFish;
    }
}
