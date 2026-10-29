
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int total = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1]
                    == nums[i - 1] - nums[i - 2]) {

                count++;
                total += count;
            } else {
                count = 0;
            }
        }

        return total;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna