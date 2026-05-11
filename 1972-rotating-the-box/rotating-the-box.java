class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        // rotate 90 degree
        char [][] rotated = new char [m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = boxGrid[i][j];
            }
        }

        // apply gravity
        for (int j = 0; j < n; j++) {
            int bottom = m - 1;  // start from bottom row
            for (int i = m-1; i >= 0; i--) {
                // get a space
                if (rotated[i][j] == '*') {
                    bottom = i - 1;  // reset bottom above obstacle
                }
                else if (rotated[i][j] == '#') {
                    if (i != bottom) {
                        rotated[bottom][j] = '#';
                        rotated[i][j] = '.';
                    }
                    bottom--;
                }
            }
        }
        return rotated;
    }
}