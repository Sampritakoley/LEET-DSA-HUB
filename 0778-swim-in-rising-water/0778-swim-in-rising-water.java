class Solution {
    public class Pair {
        int tsf; 
        int row;
        int col;

        public Pair(int tsf, int row, int col) {
            this.tsf = tsf;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.tsf - b.tsf
        );

        boolean[][] visited = new boolean[n][n];

        pq.offer(new Pair(grid[0][0], 0, 0));
        visited[0][0] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.row == n - 1 && curr.col == n - 1) {
                return curr.tsf;
            }

            for (int[] d : dirs) {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;

                    pq.offer(new Pair(
                        Math.max(curr.tsf, grid[nr][nc]),
                        nr,
                        nc
                    ));
                }
            }
        }

        return -1;
    }
}