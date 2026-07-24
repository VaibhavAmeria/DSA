class Solution {
    int[] parent;
    int[] rank;
    Map<Integer, Integer> map;

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
    
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        map = new HashMap<>();

        // Initialize each node as its own component
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Process all edges
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        long result = 0;
        long remaining = n;

        for (int i = 0; i < n; i++) {
            int parent = find(i);
            map.put(parent, map.getOrDefault(parent, 0) + 1);
        }
        
        for (int size : map.values()) {
            remaining -= size;
            result += (long) size * remaining;
        }

        return result;
    }
}