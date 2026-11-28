class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);

        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);

        List<Integer> result = new ArrayList<>();

        for (int i = lower; i < upper; i++) {
            result.add(i);
        }

        return result;
    }

    private int lowerBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int upperBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna