
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }
        long[] gcdCount = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            long count = 0;
            for (int j = g; j <= max; j += g) {
                count += freq[j];
            }
            gcdCount[g] = count * (count - 1) / 2;
            for (int j = 2 * g; j <= max; j += g) {
                gcdCount[g] -= gcdCount[j];
            }
        }
        for (int i = 1; i <= max; i++) {
            gcdCount[i] += gcdCount[i - 1];
        }
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1;

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (gcdCount[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = left;
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna