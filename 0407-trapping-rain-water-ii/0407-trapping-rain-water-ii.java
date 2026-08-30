import java.util.*;

class Solution {

    static class Cell {
        int height;
        int row;
        int col;

        Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        int rows = heightMap.length;
        int cols = heightMap[0].length;

        if (rows < 3 || cols < 3) {
            return 0;
        }

        PriorityQueue<Cell> pq =
                new PriorityQueue<>((a, b) -> a.height - b.height);

        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (r == 0 || r == rows - 1 ||
                    c == 0 || c == cols - 1) {

                    pq.offer(new Cell(heightMap[r][c], r, c));
                    visited[r][c] = true;
                }
            }
        }

        int water = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Cell current = pq.poll();

            for (int d = 0; d < 4; d++) {

                int nr = current.row + dr[d];
                int nc = current.col + dc[d];
                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;

                int neighborHeight = heightMap[nr][nc];
                if (neighborHeight < current.height) {
                    water += current.height - neighborHeight;
                }
                int newHeight =
                        Math.max(current.height, neighborHeight);

                pq.offer(new Cell(newHeight, nr, nc));
            }
        }

        return water;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna