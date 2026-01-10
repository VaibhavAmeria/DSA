class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> parentToChildren = new HashMap <>();
        Map<Integer, Integer> childToParent = new HashMap <>();

        for (int i = 0; i < n; i++) {
            parentToChildren.put(i, new ArrayList<>());
        }

        // preparing adj list and childToParent Map
        for (int i = 0; i < n; i++) {
            int node = i;
            int leftChildNode = leftChild[i];
            int rightChildNode = rightChild[i];

            if (leftChildNode != -1) {
                parentToChildren.get(node).add(leftChildNode);
                if (childToParent.containsKey(leftChildNode)) {
                    return false;
                } else {
                    childToParent.put(leftChildNode, node);
                }
            }

            if (rightChildNode != -1) {
                parentToChildren.get(node).add(rightChildNode);
                if (childToParent.containsKey(rightChildNode)) {
                    return false;
                } else {
                    childToParent.put(rightChildNode, node);
                }
            }
        }

        // make sure only one root node exists
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) {
                if (root != -1) {
                    return false;
                }
                else {
                    root = i;
                }
            }
        }

        if (root == -1) {
            return false;
        }

        // traversing if no of nodes == no of count (dont have any breakage)
        boolean [] visited = new boolean [n+1];
        Queue <Integer> queue = new LinkedList <>();
        queue.add(root);
        visited[root] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();
                for (int child : parentToChildren.get(node)) {
                    queue.add(child);
                    count++;
                    visited[child] = true;
                }
            }
        }

        return n == count;
    }
}