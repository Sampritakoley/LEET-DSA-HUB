
class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[] temp = new long[n + 1];

        return (int) mergeSort(
            prefix, temp, 0, n, lower, upper
        );
    }

    private long mergeSort(
        long[] prefix,
        long[] temp,
        int left,
        int right,
        long lower,
        long upper
    ) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = 0;
        count += mergeSort(
            prefix, temp, left, mid, lower, upper
        );
        count += mergeSort(
            prefix, temp, mid + 1, right, lower, upper
        );
        int low = mid + 1;
        int high = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (low <= right &&
                   prefix[low] - prefix[i] < lower) {
                low++;
            }
            while (high <= right &&
                   prefix[high] - prefix[i] <= upper) {
                high++;
            }

            count += high - low;
        }
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {

            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = prefix[i++];
        }

        while (j <= right) {
            temp[k++] = prefix[j++];
        }

        for (int p = left; p <= right; p++) {
            prefix[p] = temp[p];
        }

        return count;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna