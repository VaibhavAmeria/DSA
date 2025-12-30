class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Queue <Integer> queue = new LinkedList <>();
        Map <Integer, List<Integer>> map = new HashMap <>();
        boolean [] visited = new boolean [n];
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            // Add the current index to the list
            map.get(arr[i]).add(i);
        }

        queue.add(0);
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                int left = curr - 1;
                int right = curr + 1;

                if (curr == n-1) {
                    return steps;
                }
                if (right < n && visited[right] == false) {
                    visited[right] = true;
                    queue.add(right);
                }
                if (left >= 0 && visited[left] == false) {
                    visited[left] = true;
                    queue.add(left);
                }

                List<Integer> indices = map.get(arr[curr]);
                if (indices != null) {
                    for (int i : indices) {
                        if (!visited[i]) {
                            visited[i] = true;
                            queue.add(i);
                        }
                    }
                }                
                map.remove(arr[curr]);
            }
            steps++;
        }
        return -1;
    }
}