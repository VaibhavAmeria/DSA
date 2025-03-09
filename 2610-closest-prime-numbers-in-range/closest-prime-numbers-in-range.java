import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        
        // Sieve of Eratosthenes to find all primes in the range [left, right]
        boolean[] isPrime = new boolean[right + 1];
        for (int i = 2; i <= right; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Collect primes in the specified range
        for (int i = Math.max(left, 2); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Find the closest primes
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        // Return the result or {-1, -1} if no primes found
        return primes.size() < 2 ? new int[]{-1, -1} : result;
    }
}
