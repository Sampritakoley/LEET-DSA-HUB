class Solution {
    public int longestMountain(int[] arr) {

        int up = 0;
        int down = 0;
        int maxLength = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                up = 0;
                down = 0;
            }
            else if (arr[i] > arr[i - 1]) {
                if (down > 0) {
                    up = 1;
                    down = 0;
                }
                else {
                    up++;
                }
            }
            else {
                if (up > 0) {
                    down++;
                    maxLength = Math.max(maxLength, up + down + 1);
                }
            }
        }

        return maxLength;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna