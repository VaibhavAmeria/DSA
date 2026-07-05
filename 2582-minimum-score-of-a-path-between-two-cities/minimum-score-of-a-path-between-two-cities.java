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
    Queue <Integer> queue;
    void bfs (int start, Map <Integer, List<Pair>> adj) {
        // 1. Put the start node in the queue and mark it visited
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            // Take the front node out of the queue
            int curr = queue.poll();

            // Safety check: if city has no outgoing roads, skip
            if (!adj.containsKey(curr)) continue;

            // Look at all neighbors of the current node
            for (Pair neighbour : adj.get(curr)) {
                // We always update the minimum cost for every edge we see
                result = Math.min(result, neighbour.cost);

                // If we haven't visited the connected city, add it to the queue
                if (!visited[neighbour.edge]) {
                    visited[neighbour.edge] = true; // Mark visited immediately
                    queue.offer(neighbour.edge);    // Put in queue to process later
                }
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        // 1 city can be connected with multiple cities with weight info as well
        // 1 (city) -> {{2(city), 5(weight)}, {3, 2}, 5, 8}
        Map <Integer, List<Pair>> adj = new HashMap <>();
        visited = new boolean [n+1];
        queue = new LinkedList <>(); 
        result = Integer.MAX_VALUE;

        for (int [] road : roads) {
            int u = road[0];
            int v = road[1];
            int c = road[2];

            // computeIfAbsent ensures the list exists before adding to it
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair (v, c));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair (u, c));
        }

        bfs (1, adj);;
        return result;
    }
}