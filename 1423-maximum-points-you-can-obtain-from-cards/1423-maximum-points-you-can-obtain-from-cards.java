class Solution {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        if (k == n) {
            int total = 0;
            for (int x : cardPoints)
                total += x;
            return total;
        }

        int total = 0;
        for (int x : cardPoints)
            total += x;

        int windowSize = n - k;

        int windowSum = 0;

        for (int i = 0; i < windowSize; i++)
            windowSum += cardPoints[i];

        int minWindow = windowSum;

        for (int i = windowSize; i < n; i++) {

            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];

            minWindow = Math.min(minWindow, windowSum);
        }

        return total - minWindow;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna