
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(b, a));

        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> used = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll();
                    count--;

                    if (count > 0) {
                        used.add(count);
                    }

                    time++;
                } else if (!used.isEmpty()) {
                    time++;
                }
            }
            maxHeap.addAll(used);
        }

        return time;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna