class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int total = 0;
        int extra = 0;
        int maxExtra = 0;

        int left = 0;

        for (int right = 0; right < customers.length; right++) {
            if (grumpy[right] == 0) {
                total += customers[right];
            } 
            else {
                extra += customers[right];
            }
            if (right - left + 1 > minutes) {

                if (grumpy[left] == 1) {
                    extra -= customers[left];
                }

                left++;
            }
            maxExtra = Math.max(maxExtra, extra);
        }

        return total + maxExtra;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna