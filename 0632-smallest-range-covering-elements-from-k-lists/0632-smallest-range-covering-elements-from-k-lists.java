
import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);

            minHeap.offer(new int[]{value, i, 0});
            currentMax = Math.max(currentMax, value);
        }

        int bestStart = 0;
        int bestEnd = Integer.MAX_VALUE;

        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();

            int minValue = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];
            if ((long) currentMax - minValue
                    < (long) bestEnd - bestStart) {
                bestStart = minValue;
                bestEnd = currentMax;
            }
            int nextIndex = elementIndex + 1;

            if (nextIndex >= nums.get(listIndex).size()) {
                break;
            }

            int nextValue = nums.get(listIndex).get(nextIndex);

            minHeap.offer(new int[]{nextValue, listIndex, nextIndex});
            currentMax = Math.max(currentMax, nextValue);
        }

        return new int[]{bestStart, bestEnd};
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna