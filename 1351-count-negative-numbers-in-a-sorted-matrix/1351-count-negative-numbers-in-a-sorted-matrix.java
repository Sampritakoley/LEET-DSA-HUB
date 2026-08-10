
class Solution {

    public int countNegatives(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int row = 0;
        int col = cols - 1;

        int count = 0;

        while (row < rows && col >= 0) {

            if (grid[row][col] < 0) {
                count += rows - row;
                col--;
            }else{
                row++;
            }
        }

        return count;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna