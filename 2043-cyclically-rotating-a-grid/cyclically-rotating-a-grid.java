class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length; // rows    
        int n = grid[0].length; // cols

        int layers = Math.min(m/2, n/2);

        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int bottom = m-layer-1;
            int left = layer;
            int right = n-layer-1;
            List<Integer> nums = new ArrayList<>();
            
            // filling left to right
            for (int i = left; i <= right; i++) {
                nums.add(grid[top][i]);
            }

            // filling top to bottom
            for (int i = top+1; i <= bottom-1; i++) {
                nums.add(grid[i][right]);
            }

            // filling right to left
            for (int i = right; i >= left; i--) {
                nums.add(grid[bottom][i]);
            }

            // filling bottom to top
            for (int i = bottom-1; i >= top+1; i--) {
                nums.add(grid[i][left]);
            }

            int len = nums.size();
            int normalizedK = k % len;
            Collections.rotate(nums, -normalizedK);

            int idx = 0;


            // filling back grid
            for (int i = left; i <= right; i++) {
                grid[top][i] = nums.get(idx++);
            }

            for (int i = top+1; i <= bottom-1; i++) {
                grid[i][right] = nums.get(idx++);
            }

            for (int i = right; i >= left; i--) {
                grid[bottom][i] = nums.get(idx++);
            }

            for (int i = bottom-1; i >= top+1; i--) {
                grid[i][left] = nums.get(idx++);
            }
        }
        return grid;
    }
}