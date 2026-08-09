
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return letters[low % letters.length];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna