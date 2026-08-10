
class Solution {

    public int maximumCandies(int[] candies, long k) {

        int low = 1;
        int high = 0;
        for (int pile : candies) {
            high = Math.max(high, pile);
        }

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long children = 0;
            for (int pile : candies) {

                children += pile / mid;

                if (children >= k) {
                    break;
                }
            }

            if (children >= k) {

                answer = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return answer;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna