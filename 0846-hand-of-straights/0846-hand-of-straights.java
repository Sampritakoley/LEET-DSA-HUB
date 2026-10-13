import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        minHeap.addAll(freq.keySet());

        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();

            for (int card = first;
                 card < first + groupSize;
                 card++) {

                if (!freq.containsKey(card)) {
                    return false;
                }

                freq.put(card, freq.get(card) - 1);

                if (freq.get(card) == 0) {
                    freq.remove(card);

                    if (card != minHeap.peek()) {
                        return false;
                    }

                    minHeap.poll();
                }
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna