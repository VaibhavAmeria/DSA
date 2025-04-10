class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += candies[i];
            max = Math.max(max, candies[i]);
        }

        if (total < k) {
            return 0;
        }

        int start = 1;
        int end = max;

        int res = 0;
        while (start <= end) {
            int mid = start + (end-start)/2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                count += candies[i]/mid;
            }

            if (count >= k) {
                res = Math.max(res, mid);
                // res = mid;
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return res;
    }
}