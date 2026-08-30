import java.util.*;

class Solution {

    private PriorityQueue<Integer> small =
        new PriorityQueue<>(Collections.reverseOrder());

    private PriorityQueue<Integer> large =
        new PriorityQueue<>();

    private Map<Integer, Integer> delayed =
        new HashMap<>();

    private int smallSize = 0;
    private int largeSize = 0;

    private void addNum(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        rebalance();
    }

    private void removeNum(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;
        } else {
            largeSize--;
        }

        clean(small);
        clean(large);

        rebalance();
    }

    private void rebalance() {
        if (smallSize > largeSize + 1) {

            large.offer(small.poll());

            smallSize--;
            largeSize++;

            clean(small);

        } else if (smallSize < largeSize) {

            small.offer(large.poll());

            largeSize--;
            smallSize++;

            clean(large);
        }
    }

    private void clean(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (!delayed.containsKey(num)) {
                break;
            }

            heap.poll();

            int count = delayed.get(num);

            if (count == 1) {
                delayed.remove(num);
            } else {
                delayed.put(num, count - 1);
            }
        }
    }

    private double getMedian() {

        if (smallSize > largeSize) {
            return small.peek();
        }

        return ((double) small.peek()
                + (double) large.peek()) / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        double[] result = new double[n - k + 1];

        for (int i = 0; i < n; i++) {

            addNum(nums[i]);

            if (i >= k) {
                removeNum(nums[i - k]);
            }

            if (i >= k - 1) {
                result[i - k + 1] = getMedian();
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna