import java.util.Queue;
class Solution {
    static int[] x=new int[]{0,0,1,-1};
    static int[] y=new int[]{1,-1,0,0};
    public int orangesRotting(int[][] grid) {
        if(grid==null|| grid.length==0){
            return -1;
        }
        Queue<Pair> q=new LinkedList<>();
        int freshOrange=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }else if (grid[i][j]==1){
                    freshOrange++;
                }
            }
        }
        int min=-1;
        while(q.size()>0){
            Pair p=q.poll();
            min=p.time;
            for(int i=0;i<4;i++){
                int newRow=p.row+x[i];
                int newCol=p.col+y[i];
                if(newRow>=0 && newCol>=0 && newRow<grid.length && 
                    newCol<grid[0].length && grid[newRow][newCol]==1){
                        grid[newRow][newCol]=2;
                        freshOrange--;
                        q.offer(new Pair(newRow,newCol,p.time+1));
                }
            }
        }
        return freshOrange==0?min:-1;

    }
    public static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
}