class Solution {
    int[][] prefix;
    int n; // number of rows
    int m; // number of columns

    public int maxSideLength(int[][] mat, int threshold) {
        n = mat.length;
        m = mat[0].length;
        prefix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i][j] =
                        mat[i][j]
                        + (i > 0 ? prefix[i - 1][j] : 0)
                        + (j > 0 ? prefix[i][j - 1] : 0)
                        - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }

        int start = 0;
        int end = Math.min(n, m);
        int result = 0;

        // Binary search for the maximum side length
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (maxSidePossible(mid, threshold, n, m, prefix)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    boolean maxSidePossible(int side, int threshold, int rows, int cols, int [][] prefix) {
        if (side == 0)
            return true;

        for (int i = 0; i + side - 1 < rows; i++) {
            for (int j = 0; j + side - 1 < cols; j++) {

                int r2 = i + side - 1;
                int c2 = j + side - 1;

                int sum = prefix[r2][c2];
                if (i > 0) sum -= prefix[i - 1][c2];
                if (j > 0) sum -= prefix[r2][j - 1];
                if (i > 0 && j > 0) sum += prefix[i - 1][j - 1];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
