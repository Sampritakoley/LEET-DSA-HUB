public class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna