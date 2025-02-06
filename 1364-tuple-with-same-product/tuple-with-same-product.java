import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> productCount = new HashMap<>();
        int count = 0;

        // Generate all pairs and calculate their products
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Calculate the number of valid tuples
        for (int value : productCount.values()) {
            if (value > 1) {
                count += value * (value - 1) * 4; // Each pair can form 4 tuples
            }
        }

        return count;
    }
}
