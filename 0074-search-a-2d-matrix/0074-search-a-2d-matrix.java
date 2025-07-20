class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }
    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == target) return true;
            else if (row[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}