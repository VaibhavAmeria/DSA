import java.util.Arrays;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings based on start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        // Change lastAvailableAt to long[]
        long[] lastAvailableAt = new long[n];
        int[] usedCount = new int[n];
        
        for (int[] meeting : meetings) {
            boolean found = false;
            int start = meeting[0];
            int end = meeting[1];
            long duration = end - start;  // Change duration to long
            long earlyEndingRoomTime = Long.MAX_VALUE;  // Use Long.MAX_VALUE
            int earlyEndingRoom = 0;

            for (int room = 0; room < n; room++) {
                if (lastAvailableAt[room] <= start) {
                    // Assign the room
                    lastAvailableAt[room] = end;  // No change needed here
                    usedCount[room]++;
                    found = true;
                    break;
                }

                if (lastAvailableAt[room] < earlyEndingRoomTime) {
                    earlyEndingRoomTime = lastAvailableAt[room];
                    earlyEndingRoom = room;
                }
            }

            if (!found) {
                lastAvailableAt[earlyEndingRoom] += duration;  // No change needed here
                usedCount[earlyEndingRoom]++;
            }
        }

        int res = 0;
        int maxUse = 0;
        for (int i = 0; i < usedCount.length; i++) {
            if (usedCount[i] > maxUse) {
                maxUse = usedCount[i];
                res = i;
            }
        }

        return res;
    }
}
