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


    void dfs (int currNode, Map <Integer, List<Integer>> adj, boolean [] isVisited, Stack <Integer> st) {
        isVisited[currNode] = true;
        for (int ngh : adj.get(currNode)) {
            if (!isVisited[ngh]) {
                dfs (ngh, adj, isVisited, st);
            }
        }
        st.push(currNode);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean [] isVisited = new boolean [numCourses];
        boolean [] isRecVisited = new boolean [numCourses];
        Stack <Integer> st = new Stack <>();
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
                return new int [] {};
            }
        }
        Arrays.fill(isVisited, false);

        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                dfs (i, adj, isVisited, st);
            }
        }

        int [] res = new int [numCourses];
        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }
        return res;
    }
}