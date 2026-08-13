class Solution {

    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);
        if (p == 0) {
    return 0;
}

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMakePairs(nums, p, mid)) {
                answer = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canMakePairs(int[] nums, int p, int maxDiff) {

        int pairs = 0;

        int i = 0;

        while (i < nums.length - 1) {

            if (nums[i + 1] - nums[i] <= maxDiff) {

        
                pairs++;
                i += 2;

                if (pairs == p) {
                    return true;
                }

            } else {
                i++;
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna