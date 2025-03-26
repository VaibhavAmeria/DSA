class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n*m;
        int [] arr = new int [size];

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);

        int target = arr[size/2];
        int ans = 0;
        for (int i : arr) {
            if ((Math.abs(target - i) % x) == 0) {
                ans += ((Math.abs(target - i)) / x);
            }
            else {
                return -1;
            }
        }

        return ans;
    }
}