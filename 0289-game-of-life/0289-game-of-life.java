class Solution {

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbors = 0;
                for (int k = 0; k < 8; k++) {

                    int nr = row + dr[k];
                    int nc = col + dc[k];
                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols) {
                        if (board[nr][nc] == 1 ||
                            board[nr][nc] == 3) {

                            liveNeighbors++;
                        }
                    }
                }

                if (board[row][col] == 1) {

                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = 3;
                    }

                } else if (board[row][col] == 0) {

                    if (liveNeighbors == 3) {
                        board[row][col] = 2;
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 2) {
                    board[row][col] = 1;
                } else if (board[row][col] == 3) {
                    board[row][col] = 0;
                }
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna