class Solution {

    private boolean checkRowPainted(int[][] mat, int row) {
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) { // not painted
                return false;
            }
        }
        return true;
    }

    private boolean checkColPainted(int[][] mat, int col) {
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) { // not painted
                return false;
            }
        }
        return true;
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> mp = new HashMap<>(); // stores value to cell-coordinate [i][j]

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                mp.put(val, new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int[] coordinates = mp.get(val);
            int row = coordinates[0], col = coordinates[1];
            mat[row][col] *= -1; // painted

            if (checkRowPainted(mat, row) || checkColPainted(mat, col)) {
                return i;
            }
        }

        return -1;
    }
}
