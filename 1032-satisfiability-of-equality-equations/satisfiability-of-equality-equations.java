class Solution {
    int [] parent;
    int [] rank;

    int find (int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    
    void union (int x, int y) {
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

    public boolean equationsPossible(String[] equations) {
        parent = new int [26];
        rank = new int [26];

        // CRUCIAL FIX: Initialize each node to be its own parent.
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (String s : equations) {
            int x = (int) s.charAt(0) - 'a';
            int y = (int) s.charAt(s.length() - 1) - 'a';
            if (s.substring(1, 3).equals("==")) {
                // equals sign
                union(x, y);
            }
        }

        for (String s : equations) {
            int x = (int) s.charAt(0) - 'a';
            int y = (int) s.charAt(s.length() - 1) - 'a';
            if (s.substring(1, 3).equals("!=")) {
                int x_parent = find(x);
                int y_parent = find(y);

                if (x_parent == y_parent) {
                    return false;
                }
            }
        }
        return true;
    }
}