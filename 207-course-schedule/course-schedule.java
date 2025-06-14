class Solution {
    boolean isCycle (int currNode, Map <Integer, List<Integer>> adj, boolean [] isVisited, boolean [] isRecVisited) {
        if (isRecVisited[currNode]) {
            return true;
        }
        if (isVisited[currNode]) {
            return false;
        }
        isVisited[currNode] = true;
        isRecVisited[currNode] = true;
        for (int ngh : adj.get(currNode)) {
            if (isCycle(ngh, adj, isVisited, isRecVisited)) {
                return true;
            }
        }
        isRecVisited[currNode] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean [] isVisited = new boolean [numCourses];
        boolean [] isRecVisited = new boolean [numCourses];
        Map <Integer, List<Integer>> adj = new HashMap <>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList <>());
        }

        // populating adj list
        for (int [] edge : prerequisites) {
            int u = edge[1];
            int v = edge[0];
            adj.get(u).add(v);
        }

        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i, adj, isVisited, isRecVisited)) {
                return false;
            }
        }
        return true;
    }
}