class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[1], b[1]));

        int removed = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int start = intervals[i][0];
            int finish = intervals[i][1];

            if (start < end) {
                removed++;
            } else {
                end = finish;
            }
        }

        return removed;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna