
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            int current = matrix[row][col];

            if (current == target) {
                return true;
            }

            if (current > target) {
                col--;

            } else {
                row++;
            }
        }

        return false;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna