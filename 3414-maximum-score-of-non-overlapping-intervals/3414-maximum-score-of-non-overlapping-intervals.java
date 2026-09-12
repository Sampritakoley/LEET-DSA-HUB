import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class Result {
        long score;
        int[] indices;

        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    private Interval[] arr;
    private int n;
    private Result[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) {
                return Integer.compare(a.l, b.l);
            }
            if (a.r != b.r) {
                return Integer.compare(a.r, b.r);
            }
            return Integer.compare(a.idx, b.idx);
        });

        dp = new Result[n + 1][5];

        return solve(0, 4).indices;
    }

    private Result solve(int i, int k) {
        if (i >= n || k == 0) {
            return new Result(0, new int[0]);
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        Result skip = solve(i + 1, k);

        int next = upperBound(i + 1, arr[i].r);

        Result nextResult = solve(next, k - 1);

        int[] takeIndices = new int[nextResult.indices.length + 1];

        takeIndices[0] = arr[i].idx;

        System.arraycopy(
            nextResult.indices,
            0,
            takeIndices,
            1,
            nextResult.indices.length
        );

        Arrays.sort(takeIndices);

        Result take = new Result(
            arr[i].w + nextResult.score,
            takeIndices
        );

        dp[i][k] = better(take, skip);

        return dp[i][k];
    }

    private int upperBound(int start, int right) {
        int lo = start;
        int hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid].l <= right) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private Result better(Result a, Result b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return lexicographicallySmaller(a.indices, b.indices)
            ? a
            : b;
    }

    private boolean lexicographicallySmaller(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return a.length < b.length;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna