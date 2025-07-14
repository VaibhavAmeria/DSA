class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int left = firstPlayer;
        int right = secondPlayer;
        if (left == n - right + 1) {
            return new int [] {1, 1};
        }

        if (left > n - right + 1) {
            // n-right+1 -> fightsRight
            // n-left+1 -> fightsLeft

            // symetric case, hence we can shift 1 place
            int temp = n - left + 1;
            left = n - right + 1;
            right = temp;
        }

        int minRound = n;
        int maxRound = 1;
        int remainingPlayersCount = (n+1) / 2;
        if (right <= remainingPlayersCount) {
            // both best players are on same side
            int countLeft = left - 1;
            int midCount = right - left - 1;

            for (int surviourLeft = 0; surviourLeft <= countLeft; surviourLeft++) {
                for (int surviourMid = 0; surviourMid <= midCount; surviourMid++) {
                    int pos1 = surviourLeft + 1;
                    int pos2 = pos1 + surviourMid + 1;

                    int [] newCords = earliestAndLatest(remainingPlayersCount, pos1, pos2);
                    minRound = Math.min(minRound, newCords[0] + 1);
                    maxRound = Math.max(maxRound, newCords[1] + 1);
                }
            }
        }
        else {
            // both best players are on diff side
            int fightsRight = n - right + 1;
            int countLeft = left - 1;
            int midCount = fightsRight - left - 1;
            int remainingMidCount = right - fightsRight - 1;

            for (int surviourLeft = 0; surviourLeft <= countLeft; surviourLeft++) {
                for (int surviourMid = 0; surviourMid <= midCount; surviourMid++) {
                    int pos1 = surviourLeft + 1;
                    int pos2 = pos1 + surviourMid + (remainingMidCount+1)/2 + 1;
                    int [] newCords = earliestAndLatest(remainingPlayersCount, pos1, pos2);
                    minRound = Math.min(minRound, newCords[0] + 1);
                    maxRound = Math.max(maxRound, newCords[1] + 1);
                }
            }
        }

        return new int [] {minRound, maxRound};
    }
}