import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxValue(int[][] events, int k) {
        // Sort events by end time
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        
        int n = events.length;
        // DP table: dp[i][j] = max value with first i events and j selections
        int[][] dp = new int[n + 1][k + 1];

        // Fill the DP table
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                // Option 1: Skip the current event
                dp[i][j] = dp[i - 1][j];
                
                // Option 2: Take the current event
                int value = events[i - 1][2]; // value of the current event
                int endTime = events[i - 1][1];

                // Find the last event that ends before the current event starts
                int low = 0, high = i - 1;
                while (low < high) {
                    int mid = low + (high - low + 1) / 2;
                    if (events[mid - 1][1] < events[i - 1][0]) {
                        low = mid; // mid is a valid option
                    } else {
                        high = mid - 1; // mid is not valid
                    }
                }
                int prevIndex = low; // last valid event index

                // Update the DP table with the maximum value
                dp[i][j] = Math.max(dp[i][j], value + dp[prevIndex][j - 1]);
            }
        }

        return dp[n][k]; // The maximum value with n events and k selections
    }
}
