class Solution {
    public class Pair{
        int row;
        int col;
        int pathLen;
        public Pair(int row,int col,int pathLen){
            this.row=row;
            this.col=col;
            this.pathLen=pathLen;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1,  0,  1, -1, 1, -1, 0, 1};

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,0,1)); 
        grid[0][0] = 1; 
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int r = curr.row, c = curr.col, len = curr.pathLen;
            if (r == n-1 && c == n-1) return len;
            for(int k=0;k<8;k++){
                int nr = r + x[k];
                int nc = c + y[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                    queue.offer(new Pair(nr, nc, len + 1));
                    grid[nr][nc] = 1; 
                }
            }
            
        }
        return -1;
    }
}