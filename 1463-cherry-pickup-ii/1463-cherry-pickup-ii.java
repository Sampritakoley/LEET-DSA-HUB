class Solution {
    int rows, cols;
    int[][] grid;
    Integer[][][] memo;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        memo = new Integer[rows][cols][cols];
        return dfs(0, 0, cols - 1);
    }

    private int dfs(int row, int c1, int c2) {
        if (c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols) {
            return Integer.MIN_VALUE;
        }

        if (memo[row][c1][c2] != null) {
            return memo[row][c1][c2];
        }

        int cherries = (c1 == c2)
                ? grid[row][c1]
                : grid[row][c1] + grid[row][c2];

        if (row == rows - 1) {
            return cherries;
        }

        int best = 0;
        for (int dc1 = -1; dc1 <= 1; dc1++) {
            for (int dc2 = -1; dc2 <= 1; dc2++) {
                best = Math.max(best, dfs(row + 1, c1 + dc1, c2 + dc2));
            }
        }

        memo[row][c1][c2] = cherries + best;
        return memo[row][c1][c2];
    }
}