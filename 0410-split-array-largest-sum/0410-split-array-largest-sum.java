
class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;

            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    private boolean canSplit(int[] nums, int k, int maxSum) {

        int parts = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                parts++;
                currentSum = num;
                if (parts > k) {
                    return false;
                }

            } else {

                currentSum += num;
            }
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna