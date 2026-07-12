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

        Deque<int[]> dq = new ArrayDeque<>();
        result[0][0] = grid.get(0).get(0); //source {0, 0}
        dq.offerFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int [] cell = dq.pollFirst();
            int r = cell[0]; 
            int c = cell[1];

            for (int [] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR < 0 || newC < 0 || newR >= n || newC >= m) {
                    continue;
                }

                if (result[r][c] + grid.get(newR).get(newC) < result[newR][newC]) {
                    result[newR][newC] = result[r][c] + grid.get(newR).get(newC);

                    if (grid.get(newR).get(newC) == 0)
                        dq.offerFirst(new int[]{newR, newC});
                    else {
                        dq.offerLast(new int[]{newR, newC});
                    }
                }
            }
        }

        System.out.println("result[n-1][m-1] -> " + result[n-1][m-1]);
        System.out.println("health -> " + health);
        return result[n-1][m-1] < health ? true : false;
    }
}