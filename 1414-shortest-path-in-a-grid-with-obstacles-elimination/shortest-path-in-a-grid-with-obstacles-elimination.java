class Solution {
    int [][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int []> queue = new LinkedList <>();
        queue.add(new int [] {0, 0, k});
        boolean [][][] visited = new boolean [n+1][m+1][k+1];
        int steps = 0;

        // bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int [] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int rem = curr[2];

                if (r == n - 1 && c == m - 1) {
                    return steps;
                }

                for (int [] dir : dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR >= 0 && newR < n && newC >= 0 && newC < m) {
                        int newRem = rem - (grid[newR][newC] == 1 ? 1 : 0);
                        if (newRem >= 0 && !visited[newR][newC][newRem]) {
                            visited[newR][newC][newRem] = true;
                            queue.offer(new int[]{newR, newC, newRem});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}