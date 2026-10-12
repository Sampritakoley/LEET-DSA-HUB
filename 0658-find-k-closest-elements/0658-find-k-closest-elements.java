
import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x);

            if (distA != distB) {
                return Integer.compare(distB, distA);
            }
            return Integer.compare(b, a);
        });

        for (int num : arr) {
            maxHeap.offer(num);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        Collections.sort(result);
        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna