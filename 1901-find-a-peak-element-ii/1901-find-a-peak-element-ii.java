
class Solution {

    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;
            int maxRow = 0;

            for (int row = 1; row < m; row++) {

                if (mat[row][mid] > mat[maxRow][mid]) {
                    maxRow = row;
                }
            }
            if (mat[maxRow][mid] < mat[maxRow][mid + 1]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        int maxRow = 0;

        for (int row = 1; row < m; row++) {

            if (mat[row][low] > mat[maxRow][low]) {
                maxRow = row;
            }
        }

        return new int[] { maxRow, low };
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna