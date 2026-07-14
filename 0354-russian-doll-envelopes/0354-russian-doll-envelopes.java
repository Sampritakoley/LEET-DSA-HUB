class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> lis = new ArrayList<>();

        for (int[] e : envelopes) {
            int h = e[1];

            int left = 0, right = lis.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (lis.get(mid) < h)
                    left = mid + 1;
                else
                    right = mid;
            }

            if (left == lis.size())
                lis.add(h);
            else
                lis.set(left, h);
        }

        return lis.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna