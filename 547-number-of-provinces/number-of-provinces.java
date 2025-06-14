class Solution {
    void bfs (int u, Map <Integer, List<Integer>> adj, boolean [] visited) {
        Queue <Integer> queue = new LinkedList <>();
        queue.offer(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            for (int ngh : adj.get(polled)) {
                if (!visited[ngh]) {
                    visited[ngh] = true;
                    queue.offer(ngh); 
                }
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
                bfs (i, adj, visited);
                noOfProvinces++;
            }
        }
        return noOfProvinces;
    }
}