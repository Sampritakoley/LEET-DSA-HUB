
class Solution {

    private int[] start;
    private int[] memo;

    private int findNextJob(int target, int low) {

        int high = start.length - 1;
        int answer = start.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (start[mid] >= target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private int solve(int index, int[][] jobs) {

        if (index == jobs.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }
        int skip = solve(index + 1, jobs);
        int next = findNextJob(
            jobs[index][1],
            index + 1
        );
        int take = jobs[index][2]
                 + solve(next, jobs);

        return memo[index] = Math.max(take, skip);
    }

    public int jobScheduling(
        int[] startTime,
        int[] endTime,
        int[] profit
    ) {

        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{
                startTime[i],
                endTime[i],
                profit[i]
            };
        }

        Arrays.sort(jobs,
            (a, b) -> Integer.compare(a[0], b[0]));

        start = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = jobs[i][0];
        }

        memo = new int[n];
        Arrays.fill(memo, -1);

        return solve(0, jobs);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna