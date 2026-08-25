class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            for (int col = left; col <= right; col++) {
                matrix[top][col] = num++;
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            right--;

            for (int col = right; col >= left; col--) {
                matrix[bottom][col] = num++;
            }
            bottom--;

            for (int row = bottom; row >= top; row--) {
                matrix[row][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna