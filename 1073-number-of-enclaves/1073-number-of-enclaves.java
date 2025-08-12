class Solution {
    public static class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public static int[] x=new int[]{0,0,1,-1};
    public static int[] y=new int[]{1,-1,0,0};
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                q.offer(new Pair(i,0));
                grid[i][0] = -1;
            }
            if(grid[i][m-1]==1){
                q.offer(new Pair(i,m-1));
                grid[i][m-1] = -1;
            }
        }

        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                q.offer(new Pair(0,j));
                grid[0][j] = -1;
            }if(grid[n-1][j]==1){
               q.offer(new Pair(n-1,j));
               grid[n-1][j] = -1;
            }
        }

        while(q.size()>0){
            Pair p=q.poll();
            
            
            for(int k=0;k<4;k++){
                int newR=p.row+x[k];
                int newC=p.col+y[k];

                if(newR>=0 && newC>=0 && newR<n && newC<m && grid[newR][newC]==1){
                    q.offer(new Pair(newR,newC));
                    grid[newR][newC]=-1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return  count;
    }
}