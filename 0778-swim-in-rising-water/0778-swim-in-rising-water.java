class Solution {

    class Cell {
        int row, col, time;

        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int[][] time = new int[n][n];
        for (int[] row : time)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Cell> pq = new PriorityQueue<>(
            (a, b) -> a.time - b.time
        );

        time[0][0] = grid[0][0];
        pq.offer(new Cell(0, 0, grid[0][0]));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            if (curr.row == n - 1 && curr.col == n - 1)
                return curr.time;

            if (curr.time > time[curr.row][curr.col])
                continue;

            for (int k = 0; k < 4; k++) {

                int nr = curr.row + dr[k];
                int nc = curr.col + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                int newTime = Math.max(curr.time, grid[nr][nc]);

                if (newTime < time[nr][nc]) {

                    time[nr][nc] = newTime;
                    pq.offer(new Cell(nr, nc, newTime));
                }
            }
        }

        return -1;
    }
}