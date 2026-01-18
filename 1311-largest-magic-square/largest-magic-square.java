class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // RowSum
        int [][] prefixRowSum = new int [n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixRowSum[i][j] = grid[i][j] + (j - 1 < 0 ? 0 : prefixRowSum[i][j-1]);
            }
        }

        // ColSum
        int [][] prefixColSum = new int [n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                prefixColSum[i][j] = grid[i][j] + (i - 1 < 0 ? 0 : prefixColSum[i-1][j]);
            }
        }

        int maxSide = Math.min(n, m);
        for (int side = maxSide; side > 1; side--) {
            for (int i = 0; i+side-1 < n; i++) {
                for (int j = 0; j+side-1 < m; j++) {
                    int targetSum = prefixRowSum[i][j+side-1] - (j > 0 ? prefixRowSum[i][j-1] : 0);

                    boolean allSame = true;
                    for (int r = i+1; r < i+side; r++) {
                        int rowSum = prefixRowSum[r][j+side-1] - (j > 0 ? prefixRowSum[r][j-1] : 0);
                        if (rowSum != targetSum) {
                            allSame = false;
                            break;
                        }
                    }

                    if (!allSame) {
                        continue;
                    }

                    // Check all columns
                    for (int c = j; c < j + side; c++) {
                        int colSum = prefixColSum[i + side - 1][c] - (i > 0 ? prefixColSum[i - 1][c] : 0);
                        if (colSum != targetSum) {
                            allSame = false;
                            break;
                        }
                    }
                    if (!allSame) continue;

                    // Check diagonals
                    int diag = 0;
                    int antiDiag = 0;
                    for (int k = 0; k < side; k++) {
                        diag += grid[i + k][j + k];
                        antiDiag += grid[i + k][j + side - 1 - k];
                    }

                    if (diag == targetSum && antiDiag == targetSum) {
                        return side;
                    }
                }
            }
        }

        return 1;
    }
}