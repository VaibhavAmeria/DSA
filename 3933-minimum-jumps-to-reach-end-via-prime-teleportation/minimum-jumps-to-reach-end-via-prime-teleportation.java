class Solution {
    boolean [] primeNum;
    void seiveOfErato (int n) {
        primeNum = new boolean [n+1];
        Arrays.fill(primeNum, true);
        primeNum[0] = primeNum[1] = false;

        for (int i = 2; i*i <= n; i++) {
            if (primeNum[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    primeNum[j] = false;
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        int maxEle = Integer.MIN_VALUE;
        Map <Integer, List<Integer>> mapped = new HashMap <>();

        // mapped to check max where can we go
        for (int i = 0; i < n; i++) {
            maxEle = Math.max(maxEle, nums[i]);
            mapped.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // // prime no marked
        seiveOfErato(maxEle);

        Queue<Integer> queue = new LinkedList <>();
        boolean [] visited = new boolean [n+1];
        Set<Integer> seen = new HashSet <>();

        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int i = queue.poll();
                
                if (i == n-1) {
                    return steps;
                }

                // valid jump to i-1
                if (i-1 >= 0 && !visited[i-1]) {
                    queue.offer(i-1);
                    visited[i-1] = true;
                }

                // valid jump to i+1
                if (i+1 < n && !visited[i+1]) {
                    queue.offer(i+1);
                    visited[i+1] = true;
                }

                if (!primeNum[nums[i]] || seen.contains(nums[i])) {
                    continue;
                }

                // valid jump all divisibles if nums[i] is prime
                for (int multiple = nums[i]; multiple <= maxEle; multiple += nums[i]) {
                    if (!mapped.containsKey(multiple)) {
                        continue;
                    }

                    for (int key : mapped.get(multiple)) {
                        queue.offer(key);
                        visited[key] = true;
                    }
                }

                seen.add(nums[i]);
            }
            steps++;
        }

        return 0;
    }
}