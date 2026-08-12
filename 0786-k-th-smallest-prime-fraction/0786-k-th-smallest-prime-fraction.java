class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        double low = 0.0;
        double high = 1.0;

        while (low < high) {

            double mid = low + (high - low) / 2;

            int count = 0;

            int bestNumerator = 0;
            int bestDenominator = 1;

            int i = 0;

            for (int j = 1; j < arr.length; j++) {

                while (i < j && arr[i] <= mid * arr[j]) {
                    i++;
                }

                count += i;

                if (i > 0) {

                    int numerator = arr[i - 1];
                    int denominator = arr[j];

                    if ((double) numerator / denominator
                            > (double) bestNumerator / bestDenominator) {

                        bestNumerator = numerator;
                        bestDenominator = denominator;
                    }
                }
            }

            if (count == k) {
                return new int[]{bestNumerator, bestDenominator};
            }

            if (count < k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return new int[]{0, 1};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna