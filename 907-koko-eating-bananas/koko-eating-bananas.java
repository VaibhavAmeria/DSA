class Solution {
    int possibleHours (int [] piles, int val, int n) {
        int hoursToBeTaken = 0;
        for (int i = 0; i < n; i++) {
            hoursToBeTaken += Math.ceil((double)piles[i]/val);
        }
        return hoursToBeTaken;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);

        int l = 0;
        int r = piles[n-1];
        int res = r;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (possibleHours(piles, mid, n) <= h) {
                res = Math.min(res, mid);
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return res;
    }
}