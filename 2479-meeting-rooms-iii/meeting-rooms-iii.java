class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings based on start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        // PriorityQueue to manage rooms based on their ending time
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                // if ending times are not equal
                // sort based on their ending times
                return a[0] - b[0];
            } else {
                // else sort based on room no's
                return a[1] - b[1];
            }
        });
        
        // PriorityQueue to manage free rooms (smallest room number first)
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            free.add(i);
        }
        
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            
            // Release rooms that have become available by the current start time
            while (!occupied.isEmpty() && occupied.peek()[0] <= start) {
                int[] room = occupied.poll();
                free.add(room[1]);
            }
            
            if (!free.isEmpty()) {
                // Assign to the smallest available free room
                int room = free.poll();
                count[room]++;
                occupied.add(new int[] {end, room});
            } else {
                // Wait for the next available room
                int[] room = occupied.poll();
                count[room[1]]++;
                occupied.add(new int[] {room[0] + duration, room[1]});
            }
        }
        
        // Find the room with the maximum bookings
        int maxCount = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = i;
            }
        }
        return result;
    }
}