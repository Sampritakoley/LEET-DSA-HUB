class Solution {
    int[][] dp;                
    int rows, cols;

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows][cols];

        int maxPath = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        int best = 1;

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni >= 0 && nj >= 0 && ni < rows && nj < cols &&
                matrix[ni][nj] > matrix[i][j]) {
                best = Math.max(best, 1 + dfs(matrix, ni, nj));
            }
        }

        dp[i][j] = best;
        return best;
    }
}
