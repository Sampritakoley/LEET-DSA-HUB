class Solution {
    public static int[] x=new int[]{0,0,1,-1};
    public static int[] y=new int[]{1,-1,0,0};
    public static class Pair{
        int row;
        int col;
        int level;
        public Pair(int row,int col,int level){
            this.row=row;
            this.col=col;
            this.level=level;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] res=new int[mat.length][mat[0].length];
        for(int[] row:res){
            Arrays.fill(row,-1);
        }
        Bfs(mat,res);
        return res;
    }
    public static void Bfs(int[][] mat,int[][] res){
        Queue<Pair> q=new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        while(q.size()>0){
            Pair p=q.poll();
            for(int k=0;k<4;k++){
                int newR=p.row+x[k];
                int newC=p.col+y[k];
                if (newR >= 0 && newR < mat.length && newC >= 0 && newC < mat[0].length && res[newR][newC] == -1){
                    res[newR][newC]=p.level+1;
                    q.offer(new Pair(newR,newC,p.level+1));
                }
            }
        }
    }
}