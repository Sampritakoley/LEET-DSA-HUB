
import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] previous = null;

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            
            result.append((char) (current[0] + 'a'));
            current[1]--;
            if (previous != null && previous[1] > 0) {
                maxHeap.offer(previous);
            }
            previous = current;
        }
        if (result.length() != s.length()) {
            return "";
        }

        return result.toString();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna