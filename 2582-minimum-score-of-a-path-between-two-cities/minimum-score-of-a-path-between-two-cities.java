class Pair {
    int edge;
    int cost;
    Pair (int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }
}

class Solution {
    boolean [] visited;
    int result;
    void dfs (int start, int end, Map <Integer, List<Pair>> adj) {
        visited[start] = true;

        // Safety check: if the node has no outward edges, stop.
        if (!adj.containsKey(start)) return;

        for (Pair neighbour : adj.get(start)) {
            result = Math.min(result, neighbour.cost);
            if (!visited[neighbour.edge]) {
                dfs(neighbour.edge, end, adj);
            }
        }

    }

    public int minScore(int n, int[][] roads) {
        // 1 city can be connected with multiple cities with weight info as well
        // 1 (city) -> {{2(city), 5(weight)}, {3, 2}, 5, 8}
        Map <Integer, List<Pair>> adj = new HashMap <>();
        visited = new boolean [n+1];
        result = Integer.MAX_VALUE;

        for (int [] road : roads) {
            int u = road[0];
            int v = road[1];
            int c = road[2];

            // computeIfAbsent ensures the list exists before adding to it
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair (v, c));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair (u, c));
        }

        dfs (1, n, adj);;
        return result;
    }
}