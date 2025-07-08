class Solution {
     public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int n = events.length;

        int[] startDays = new int[n];
        for (int i = 0; i < n; i++) {
            startDays[i] = events[i][0];
        }

        Integer[][] dp = new Integer[n][k + 1];

        return dfs(0, k, events, dp, startDays);
    }

    private int dfs(int index, int remaining, int[][] events, Integer[][] dp, int[] startDays) {
        if (index == events.length || remaining == 0) {
            return 0;
        }

        if (dp[index][remaining] != null) {
            return dp[index][remaining];
        }

        int skip = dfs(index + 1, remaining, events, dp, startDays);

        int nextIndex = findNext(events, startDays, events[index][1]);
        int take = events[index][2] + dfs(nextIndex, remaining - 1, events, dp, startDays);

        dp[index][remaining] = Math.max(skip, take);
        return dp[index][remaining];
    }

    private int findNext(int[][] events, int[] startDays, int currentEndDay) {
        int low = 0, high = events.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (startDays[mid] > currentEndDay) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}