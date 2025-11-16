class Solution {
    public class Cell{
        public int row;
        public int col;
        public int effort;
        public Cell(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
         int m = heights.length;
        int n = heights[0].length;
        
        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<Cell> pq = 
            new PriorityQueue<>((a, b) -> a.effort - b.effort); 

        effort[0][0] = 0;
        pq.add(new Cell(0, 0, 0));

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()){
            Cell cur = pq.poll();
            int r = cur.row, c = cur.col, currEffort = cur.effort;
            
            if (r == m - 1 && c == n - 1) return currEffort;
            for (int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                int newEffort = Math.max(currEffort, diff);
                if (newEffort < effort[nr][nc]) {
                    effort[nr][nc] = newEffort;
                    pq.add(new Cell(nr, nc, newEffort));
                }
            }
        }

        return 0;
    }

}