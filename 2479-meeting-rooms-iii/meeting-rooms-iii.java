class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // sort based on starting time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int [] held = new int [n];
        // a[0] -> ending time
        // a[1] -> room occupied
        PriorityQueue <int []> occupied = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            else {
                return a[1] - b[1];
            }
        });

        // sort rooms based on freely first room available
        PriorityQueue <Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            free.add(i);
        }

        for (int [] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            while (!occupied.isEmpty() && occupied.peek()[0] <= start) {
                // free room available, add it in free
                int room = occupied.poll()[1];
                free.add(room);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                held[room]++;
                occupied.add(new int [] {end, room});
            }
            else {
                // wait for next available room
                int [] room = occupied.poll();
                held[room[1]]++;
                occupied.add(new int [] {room[0] + duration, room[1]});
            }
        }

        int maxCount = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (held[i] > maxCount) {
                maxCount = held[i];
                result = i;
            }
        }
        return result;
    }
}