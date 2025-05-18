class Solution {
    public List<String> columnStates = new ArrayList<>();
    public int[][] t;
    public final int MOD = (int) (1e9 + 7);
    int solve (int remainingCols, int prevColumnIdx, int m) {
        if (remainingCols == 0) return 1;
        if (t[remainingCols][prevColumnIdx] != -1) return t[remainingCols][prevColumnIdx];

        int totalWays = 0;
        String prevColumn = columnStates.get(prevColumnIdx);

        for (int nextColumnIdx = 0; nextColumnIdx < columnStates.size(); nextColumnIdx++) {
            String nextColumn = columnStates.get(nextColumnIdx);
            boolean valid = true;

            // Check horizontal adjacency (no same color in same row across adjacent columns)
            for (int r = 0; r < m; r++) {
                if (prevColumn.charAt(r) == nextColumn.charAt(r)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                totalWays = (totalWays + solve(remainingCols - 1, nextColumnIdx, m)) % MOD;
            }
        }

        return t[remainingCols][prevColumnIdx] = totalWays;
    }

    public void generateColumnStates (String currentColumn, int rowsRemaining, char prevColor) {
        if (rowsRemaining == 0) {
            columnStates.add(currentColumn);
            return;
        }
        for (char color : new char [] {'R', 'G', 'B'}) {
            if (color == prevColor) {
                continue;
            }
            generateColumnStates(currentColumn + color, rowsRemaining - 1, color);
        }
    }
    public int colorTheGrid(int m, int n) {
        // m -> no of rows
        // n -> no of cols
        columnStates.clear();
        generateColumnStates("", m, '#'); // '#' denotes no previous color

        int numColumnPatterns = columnStates.size();
        t = new int[n][numColumnPatterns];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        int result = 0;
        for (int i = 0; i < numColumnPatterns; i++) {
            result = (result + solve(n - 1, i, m)) % MOD;
        }

        return result;
    }
}