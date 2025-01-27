class Solution {
    boolean bfs (Map <Integer, List <Integer>> adj, int src, int dest, boolean [] visited) {
        Queue <Integer> queue = new LinkedList <>();
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == dest) {
                return true;
            }
            for (int adjNode : adj.getOrDefault(curr, new ArrayList <>())) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.add(adjNode);
                }
            }
        }
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map <Integer, List <Integer>> adj = new HashMap <>();
        for (int [] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList <>()).add(v);
        }


        List <Boolean> res = new ArrayList <>();
        for (int [] query : queries) {
            int src = query[0];
            int dest = query[1];
            boolean[] visited = new boolean[numCourses];
            res.add(bfs(adj, src, dest, visited));
        }

        return res;
    }
}