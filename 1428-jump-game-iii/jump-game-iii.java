class Solution {
    boolean soln (int [] arr, int i, int n, boolean [] visited) {
        if (i < 0 || i >= n || visited[i]) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        // Mark this index as visited
        visited[i] = true;
        return soln (arr, i+arr[i], n, visited) || soln (arr, i-arr[i], n, visited);
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean [] visited = new boolean [n];
        return soln(arr, start, n, visited);
    }
}