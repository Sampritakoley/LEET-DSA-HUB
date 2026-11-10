
class Solution {
    public long continuousSubarrays(int[] nums) {

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            while (nums[maxDeque.peekFirst()] -
                   nums[minDeque.peekFirst()] > 2) {

                left++;
                while (!maxDeque.isEmpty() &&
                       maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                while (!minDeque.isEmpty() &&
                       minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            count += right - left + 1;
        }

        return count;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna