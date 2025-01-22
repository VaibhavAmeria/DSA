class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue <int []> queue = new LinkedList <>();
        int freshOranges = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int [] {i, j});
                }
                else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }


        if (freshOranges == 0) {
            return 0;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int [] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int [] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.add(new int [] {newX, newY});
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        return freshOranges == 0 ? time - 1 : -1;
    }
}