
class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {

                if (matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna