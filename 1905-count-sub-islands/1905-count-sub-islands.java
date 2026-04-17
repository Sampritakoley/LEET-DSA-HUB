class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length, n = grid1[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0)
            return true;

        grid2[i][j] = 0;

        boolean isSubIsland = true;
        if (grid1[i][j] == 0) {
            isSubIsland = false;
        }
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);

        return isSubIsland & up & down & left & right;
    }
}