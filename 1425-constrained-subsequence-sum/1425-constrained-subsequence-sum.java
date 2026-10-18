
import java.util.*;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty()
                    && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            int bestPrevious = deque.isEmpty()? 0: Math.max(0, dp[deque.peekFirst()]);

            dp[i] = nums[i] + bestPrevious;
            answer = Math.max(answer, dp[i]);
            while (!deque.isEmpty()
                    && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna