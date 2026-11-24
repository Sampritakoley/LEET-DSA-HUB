
class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {

        int m = queries.length;
        if (!isPossible(nums, queries, m)) {
            return -1;
        }
        int low = 0;
        int high = m;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (isPossible(nums, queries, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] nums, int[][] queries, int k) {

        int n = nums.length;
        long[] diff = new long[n + 1];
        for (int i = 0; i < k; i++) {

            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            diff[r + 1] -= val;
        }
        long available = 0;

        for (int i = 0; i < n; i++) {

            available += diff[i];

            if (available < nums[i]) {
                return false;
            }
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna