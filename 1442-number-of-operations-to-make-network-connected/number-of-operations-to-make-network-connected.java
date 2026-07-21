class Solution {
    int[] parent;
    int[] rank;

    int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    
    void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        
        if (x_parent == y_parent) {
            return;
        }
        
        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        }
        else if (rank[y_parent] > rank[x_parent]) {
            parent[x_parent] = y_parent;
        }
        else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        // 1. If there aren't enough total edges to connect n nodes, it's impossible.
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // We start needing n - 1 edges to connect all components
        int nodesNotConnected = n - 1;

        // 2. Process ALL connections
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];

            int x_parent = find(x);
            int y_parent = find(y);

            // If they don't share a parent, merge them and reduce the target
            if (x_parent != y_parent) {
                union(x, y);
                nodesNotConnected--;
            }
        }

        // 3. The remaining unconnected components dictates the operations needed
        return nodesNotConnected;
    }
}