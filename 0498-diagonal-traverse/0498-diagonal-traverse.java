class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];

        int index = 0;

        for (int diagonal = 0;
             diagonal < rows + cols - 1;
             diagonal++) {

            int row;
            int col;

            if (diagonal < cols) {
                row = 0;
                col = diagonal;
            } else {
                row = diagonal - cols + 1;
                col = cols - 1;
            }

            List<Integer> temp = new ArrayList<>();

            while (row < rows && col >= 0) {
                temp.add(mat[row][col]);

                row++;
                col--;
            }
            if (diagonal % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int num : temp) {
                result[index++] = num;
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna