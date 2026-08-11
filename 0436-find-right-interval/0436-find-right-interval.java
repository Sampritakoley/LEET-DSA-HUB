
class Solution {

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[][] starts = new int[n][2];

        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            int end = intervals[i][1];

            int low = 0;
            int high = n - 1;
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (starts[mid][0] >= end) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (low == n) {
                answer[i] = -1;
            } else {
                answer[i] = starts[low][1];
            }
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna