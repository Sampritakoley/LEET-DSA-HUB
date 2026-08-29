class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;

        int m = n - k + 1;

        int[] windowSum = new int[m];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (i >= k) {
                sum -= nums[i - k];
            }

            if (i >= k - 1) {
                windowSum[i - k + 1] = sum;
            }
        }

        int[] left = new int[m];

        left[0] = 0;

        for (int i = 1; i < m; i++) {

            if (windowSum[i] > windowSum[left[i - 1]]) {
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }

        int[] right = new int[m];

        right[m - 1] = m - 1;

        for (int i = m - 2; i >= 0; i--) {

            if (windowSum[i] >= windowSum[right[i + 1]]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        int[] answer = new int[3];

        int maxSum = Integer.MIN_VALUE;

        for (int middle = k; middle < m - k; middle++) {

            int leftIndex = left[middle - k];
            int rightIndex = right[middle + k];

            int total =
                    windowSum[leftIndex]
                    + windowSum[middle]
                    + windowSum[rightIndex];

            if (total > maxSum) {
                maxSum = total;

                answer[0] = leftIndex;
                answer[1] = middle;
                answer[2] = rightIndex;
            }
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna