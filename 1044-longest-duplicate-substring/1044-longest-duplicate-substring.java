
class Solution {

    public String longestDupSubstring(String s) {

        int n = s.length();

        int left = 1;
        int right = n - 1;

        int bestStart = -1;
        int bestLength = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int start = search(s, mid);

            if (start != -1) {
                bestStart = start;
                bestLength = mid;

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (bestStart == -1) {
            return "";
        }

        return s.substring(bestStart, bestStart + bestLength);
    }

    private int search(String s, int len) {

        int n = s.length();

        long base = 26;
        long mod = (1L << 31) - 1;

        long power = 1;

        for (int i = 0; i < len; i++) {
            power = (power * base) % mod;
        }

        long hash = 0;

        for (int i = 0; i < len; i++) {
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
        }

        java.util.HashMap<Long, java.util.List<Integer>> map =
            new java.util.HashMap<>();

        map.computeIfAbsent(hash, k -> new java.util.ArrayList<>()).add(0);

        for (int i = len; i < n; i++) {

            hash = (hash * base
                    - (s.charAt(i - len) - 'a') * power
                    + (s.charAt(i) - 'a')) % mod;

            if (hash < 0) {
                hash += mod;
            }

            int start = i - len + 1;

            if (map.containsKey(hash)) {

                for (int prev : map.get(hash)) {

                    if (s.regionMatches(prev, s, start, len)) {
                        return start;
                    }
                }
            }

            map.computeIfAbsent(hash, k -> new java.util.ArrayList<>())
               .add(start);
        }

        return -1;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna