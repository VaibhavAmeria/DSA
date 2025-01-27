class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        preprocess(numCourses, adjList, isPrerequisite);
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }
    private void preprocess(int numCourses, Map<Integer, List<Integer>> adjList, boolean[][] isPrerequisite) {
        for (int u = 0; u < numCourses; u++) {
            for (int v = 0; v < numCourses; v++) {
                if (u != v) {
                    boolean[] visited = new boolean[numCourses];
                    if (dfs(adjList, visited, u, v)) {
                        isPrerequisite[u][v] = true;
                    }
                }
            }
        }
    }
    private boolean dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int src, int target) {
        visited[src] = true;

        if (src == target) {
            return true;
        }

        for (int adjNode : adjList.getOrDefault(src, new ArrayList<>())) {
            if (!visited[adjNode] && dfs(adjList, visited, adjNode, target)) {
                return true;
            }
        }
        return false;
    }
}