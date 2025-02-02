class Solution {
    private int m, n;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private int DFS(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = id;
        int count = 1;
        
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            count += DFS(grid, x, y, id);
        }
        
        return count;
    }
    
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = DFS(grid, i, j, islandId);
                    maxArea = Math.max(maxArea, size);
                    islandSizes.put(islandId, size);
                    islandId++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0) {
                            uniqueIslands.add(grid[x][y]);
                        }
                    }
                    
                    int sum = 1; // converting current 0 to 1
                    for (int id : uniqueIslands) {
                        sum += islandSizes.get(id);
                    }
                    maxArea = Math.max(maxArea, sum);
                }
            }
        }
        
        return maxArea;
    }
}
