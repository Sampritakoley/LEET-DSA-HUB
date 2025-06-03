class Solution {
    public int snakesAndLadders(int[][] board) {
         int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int square = current[0];
            int moves = current[1];

            for (int i = 1; i <= 6 && square + i <= n * n; i++) {
                int next = square + i;
                int[] pos = getCoordinates(next, n);
                int dest = board[pos[0]][pos[1]] == -1 ? next : board[pos[0]][pos[1]];

                if (dest == n * n) return moves + 1;
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.add(new int[]{dest, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (square - 1) % n;

        if ((n - row) % 2 == 0) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}