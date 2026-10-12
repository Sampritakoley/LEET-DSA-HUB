
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

       PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
    if (freq.get(a).equals(freq.get(b))) {
        return Character.compare(a, b); 
    }
    return Integer.compare(freq.get(b), freq.get(a));
});
        maxHeap.addAll(freq.keySet());
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = freq.get(ch);

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna