import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();

        minHeap.offer(1L);
        seen.add(1L);

        long ugly = 1;

        for (int i = 0; i < n; i++) {
            ugly = minHeap.poll();

            long a = ugly * 2;
            long b = ugly * 3;
            long c = ugly * 5;

            if (seen.add(a)) {
                minHeap.offer(a);
            }

            if (seen.add(b)) {
                minHeap.offer(b);
            }

            if (seen.add(c)) {
                minHeap.offer(c);
            }
        }

        return (int) ugly;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna