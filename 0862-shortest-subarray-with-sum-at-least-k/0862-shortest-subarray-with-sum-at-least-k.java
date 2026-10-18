
import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int minLength = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty()
                    && prefix[i] - prefix[deque.peekFirst()] >= k) {

                minLength = Math.min(
                    minLength,
                    i - deque.pollFirst()
                );
            }
            while (!deque.isEmpty()
                    && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        return minLength == n + 1 ? -1 : minLength;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna