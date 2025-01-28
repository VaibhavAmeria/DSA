class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        ArrayList<int[]> fishCells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    fishCells.add(new int[]{i, j});
                }
            }
        }

        int maxFish = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] cell : fishCells) {
            int x = cell[0];
            int y = cell[1];
            if (!visited[x][y]) {
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
                int currSum = 0;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int currX = curr[0];
                    int currY = curr[1];
                    currSum += grid[currX][currY];

                    for (int[] dir : directions) {
                        int newX = currX + dir[0];
                        int newY = currY + dir[1];
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
        return maxFish;
    }
}
