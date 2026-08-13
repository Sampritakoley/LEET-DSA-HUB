class MedianFinder {

    private PriorityQueue<Integer> left;

    private PriorityQueue<Integer> right;

    public MedianFinder() {

        left = new PriorityQueue<>(Collections.reverseOrder());

        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        left.offer(num);

        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return ((double) left.peek() + right.peek()) / 2.0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna