
import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right],
                     freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > k) {
                int value = nums[left];
                freq.put(value, freq.get(value) - 1);

                if (freq.get(value) == 0) {
                    freq.remove(value);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna