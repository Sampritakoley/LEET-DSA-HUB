class Solution {

    class Cell {
        int row, col, effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];

        for (int[] row : effort)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Cell> pq =
            new PriorityQueue<>((a, b) -> a.effort - b.effort);

        effort[0][0] = 0;
        pq.offer(new Cell(0, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            if (curr.row == rows - 1 && curr.col == cols - 1)
                return curr.effort;

            if (curr.effort > effort[curr.row][curr.col])
                continue;

            for (int k = 0; k < 4; k++) {

                int nr = curr.row + dr[k];
                int nc = curr.col + dc[k];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                    continue;

                int diff = Math.abs(
                    heights[curr.row][curr.col] - heights[nr][nc]
                );

                int newEffort = Math.max(curr.effort, diff);

                if (newEffort < effort[nr][nc]) {

                    effort[nr][nc] = newEffort;
                    pq.offer(new Cell(nr, nc, newEffort));
                }
            }
        }

        return 0;
    }
}