class Solution {
    int [][] directions = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        // If start or end is blocked and health is insufficient
        if (grid.get(0).get(0) == 1 && health <= 1) return false;
        if (grid.get(n-1).get(m-1) == 1 && health <= 1) return false;
        
        // BFS with health tracking
        int[][] result = new int[n][m];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        result[0][0] = grid.get(0).get(0); //source {0, 0}
        queue.offer(new int[]{0, 0, result[0][0]});

        while (!queue.isEmpty()) {
            int [] cell = queue.poll();
            int r = cell[0]; 
            int c = cell[1];
            int w = cell[2];

            for (int [] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR < 0 || newC < 0 || newR >= n || newC >= m) {
                    continue;
                }

                if (result[r][c] + grid.get(newR).get(newC) < result[newR][newC]) {
                    result[newR][newC] = result[r][c] + grid.get(newR).get(newC);

                    queue.offer(new int [] {newR, newC, result[newR][newC]});
                }
            }
        }
        return result[n-1][m-1] < health ? true : false;
    }
}