class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sorted based on starting day
        
        // storing ending days for event staring on same day = day
        PriorityQueue <Integer> pq = new PriorityQueue <>();
        int day = events[0][0]; // starting day
        int i = 0; // curr index
        int attendedEvents = 0;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty()) {
                // current event startdate is starting day
                day = events[i][0];
            }

            while (i < n && events[i][0] == day) {
                pq.add(events[i][1]);
                i++;
            }

            if (!pq.isEmpty()) {
                pq.poll(); //event attended for same day
                attendedEvents++;
            }
            day++;

            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
        }
        return attendedEvents;
    }
}