class Solution {

    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (digitSum(nums[i]) == i) {
                return i;
            }
        }

        return -1;
    }

    private int digitSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna