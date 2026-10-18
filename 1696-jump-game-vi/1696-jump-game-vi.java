
import java.util.*;

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();

        dp[0] = nums[0];
        deque.offerLast(0);

        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty()
                    && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = nums[i] + dp[deque.peekFirst()];
            while (!deque.isEmpty()
                    && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        return dp[n - 1];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna