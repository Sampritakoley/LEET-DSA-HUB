import java.util.*;

class Solution {

    public int maximumRemovals(String s, String p, int[] removable) {

        int low = 0;
        int high = removable.length;
        while (low < high) {

            int mid = low + (high - low + 1) / 2;

            if (isValid(s, p, removable, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isValid(
        String s,
        String p,
        int[] removable,
        int k
    ) {
        boolean[] removed = new boolean[s.length()];

        int operation = 0;

        while (operation < k) {

            int index = removable[operation];

            removed[index] = true;

            operation++;
        }
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (removed[i]) {
                continue;
            }
            if (j < p.length() && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }

        return j == p.length();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna