
import java.util.*;

class Solution {

    public int maxDistance(int side, int[][] points, int k) {

        int n = points.length;

        long perimeter = 4L * side;

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {

            int x = points[i][0];
            int y = points[i][1];

            if (x == 0) {
                nums[i] = y;
            }
            else if (y == side) {
                nums[i] = (long) side + x;
            }
            else if (x == side) {
                nums[i] = 3L * side - y;
            }
            else {
                nums[i] = 4L * side - x;
            }
        }
        Arrays.sort(nums);
        int low = 0;
        int high = side;

        while (low < high) {

            int mid = low + (high - low + 1) / 2;

            if (canSelect(nums, perimeter, k, mid)) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canSelect(
        long[] nums,
        long perimeter,
        int k,
        int d
    ) {

        int n = nums.length;
        long[] arr = new long[2 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i] + perimeter;
        }
        for (int start = 0; start < n; start++) {

            int current = start;
            long limit = arr[start] + perimeter - d;

            boolean possible = true;
            for (int count = 1; count < k; count++) {

                long target = arr[current] + d;

                int next = lowerBound(
                    arr,
                    target,
                    current + 1,
                    start + n
                );

                if (next == start + n || arr[next] > limit) {
                    possible = false;
                    break;
                }

                current = next;
            }

            if (possible) {
                return true;
            }
        }

        return false;
    }
    private int lowerBound(
        long[] arr,
        long target,
        int left,
        int right
    ) {

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna