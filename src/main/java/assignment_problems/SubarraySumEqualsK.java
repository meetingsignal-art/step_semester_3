package assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: empty prefix has sum 0

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if there exists a previous prefix sum such that
            // currentSum - previousSum = k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumCount.put(currentSum,
                    prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
