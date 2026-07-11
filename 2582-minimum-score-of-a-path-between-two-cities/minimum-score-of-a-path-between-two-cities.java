class Solution {
    int result;
    Queue <Integer> queue;
    boolean [] visited;

    void bfs (int start, Map <Integer, List <int []>> adj) {
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int ele = queue.poll();

            if (!adj.containsKey(ele)) continue;

            List <int []> neighbours = adj.get(ele);
            for (int [] neighbour : neighbours) {
                int node = neighbour[0];
                int wt = neighbour[1];
                result = Math.min(result, wt);
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        Map <Integer, List <int []>> adj = new HashMap <>();
        queue = new LinkedList <>();
        result = Integer.MAX_VALUE;
        visited = new boolean [n+1]; 
        for (int [] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj.computeIfAbsent(u, k -> new ArrayList <>()).add(new int [] {v, w});
            adj.computeIfAbsent(v, k -> new ArrayList <>()).add(new int [] {u, w});
        }

        bfs (1, adj);
        return result;
    }
}