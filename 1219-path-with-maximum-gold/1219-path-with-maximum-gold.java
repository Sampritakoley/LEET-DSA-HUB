class Solution {

    int[][] dir = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public int getMaximumGold(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int answer = 0;

        for(int r=0;r<rows;r++) {

            for(int c=0;c<cols;c++) {

                if(grid[r][c] > 0) {

                    answer =
                        Math.max(
                            answer,
                            dfs(grid,r,c)
                        );
                }
            }
        }

        return answer;
    }

    private int dfs(int[][] grid,
                    int r,
                    int c) {

        if(r < 0 ||
           c < 0 ||
           r >= grid.length ||
           c >= grid[0].length ||
           grid[r][c] == 0) {

            return 0;
        }

        int gold = grid[r][c];

        grid[r][c] = 0;

        int best = 0;

        best = Math.max(best,
                        dfs(grid,r+1,c));

        best = Math.max(best,
                        dfs(grid,r-1,c));

        best = Math.max(best,
                        dfs(grid,r,c+1));

        best = Math.max(best,
                        dfs(grid,r,c-1));

        grid[r][c] = gold;

        return gold + best;
    }
}