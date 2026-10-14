
import java.util.*;

class StockPrice {
    private Map<Integer, Integer> prices;
    private PriorityQueue<int[]> minHeap;
    private PriorityQueue<int[]> maxHeap;
    private int latestTimestamp;

    public StockPrice() {
        prices = new HashMap<>();
        minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        latestTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        prices.put(timestamp, price);

        minHeap.offer(new int[]{price, timestamp});
        maxHeap.offer(new int[]{price, timestamp});

        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }

    public int current() {
        return prices.get(latestTimestamp);
    }

    public int maximum() {
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.peek();

            int price = top[0];
            int timestamp = top[1];
            if (prices.get(timestamp) != price) {
                maxHeap.poll();
            } else {
                return price;
            }
        }

        return -1;
    }

    public int minimum() {
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.peek();

            int price = top[0];
            int timestamp = top[1];
            if (prices.get(timestamp) != price) {
                minHeap.poll();
            } else {
                return price;
            }
        }

        return -1;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna