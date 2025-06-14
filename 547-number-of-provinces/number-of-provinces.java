class Solution {
    void dfs (int u, Map <Integer, List<Integer>> adj, boolean [] visited) {
        visited[u] = true;
        for (int ngh : adj.get(u)) {
            if (!visited[ngh]) {
                visited[ngh] = true;
                dfs (ngh, adj, visited);   
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        Map <Integer, List<Integer>> adj = new HashMap <>();
        boolean [] visited = new boolean [isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        // preparing adj list
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        int noOfProvinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs (i, adj, visited);
                noOfProvinces++;
            }
        }
        return noOfProvinces;
    }
}