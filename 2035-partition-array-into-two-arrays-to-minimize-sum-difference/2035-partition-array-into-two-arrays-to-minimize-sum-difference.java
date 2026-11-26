
import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        long total = 0;

        for (int num : nums) {
            total += num;
        }
        long[][] left = new long[n + 1][];
        long[][] right = new long[n + 1][];

        List<Long>[] leftList = new ArrayList[n + 1];
        List<Long>[] rightList = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftList[i] = new ArrayList<>();
            rightList[i] = new ArrayList<>();
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            long leftSum = 0;
            long rightSum = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {

                if ((mask & (1 << j)) != 0) {
                    leftSum += nums[j];
                    rightSum += nums[j + n];
                    count++;
                }
            }

            leftList[count].add(leftSum);
            rightList[count].add(rightSum);
        }
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightList[i]);
        }

        long answer = Long.MAX_VALUE;
        for (int k = 0; k <= n; k++) {

            for (long leftSum : leftList[k]) {

                List<Long> list = rightList[n - k];

                int low = 0;
                int high = list.size();

                while (low < high) {

                    int mid = low + (high - low) / 2;

                    long sum = leftSum + list.get(mid);

                    if (2L * sum < total) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                if (low < list.size()) {

                    long sum = leftSum + list.get(low);

                    answer = Math.min(
                        answer,
                        Math.abs(total - 2L * sum)
                    );
                }
                if (low > 0) {

                    long sum = leftSum + list.get(low - 1);

                    answer = Math.min(
                        answer,
                        Math.abs(total - 2L * sum)
                    );
                }
            }
        }

        return (int) answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna