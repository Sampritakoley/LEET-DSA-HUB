class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {

                low = mid + 1;

            } else if (nums[mid] > target) {

                high = mid - 1;

            } else {
                answer = mid;

                high = mid - 1;
            }
        }

        return answer;
    }

    private int findLast(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {

                low = mid + 1;

            } else if (nums[mid] > target) {

                high = mid - 1;

            } else {
                answer = mid;
                low = mid + 1;
            }
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna