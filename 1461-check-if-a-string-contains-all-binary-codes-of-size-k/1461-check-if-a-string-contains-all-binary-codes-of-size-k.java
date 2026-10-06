import java.util.*;

class Solution {

    public boolean hasAllCodes(String s, int k) {

        int n = s.length();

        if (n < k) {
            return false;
        }

        int totalCodes = 1 << k;
        if (n - k + 1 < totalCodes) {
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        int current = 0;

        for (int i = 0; i < k; i++) {
            current = (current << 1) | (s.charAt(i) - '0');
        }

        nodes.add(current);
        for (int i = k; i < n; i++) {

            int nextBit = s.charAt(i) - '0';
            int mask = (1 << (k - 1)) - 1;

            int next = ((current & mask) << 1) | nextBit;
            graph
                .computeIfAbsent(current, x -> new ArrayList<>())
                .add(next);
            nodes.add(next);

            current = next;
        }
        return nodes.size() == totalCodes;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna