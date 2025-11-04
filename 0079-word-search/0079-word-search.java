class Solution {
    public boolean exist(char[][] board, String word) {
         boolean[][] visited=new boolean[board.length][board[0].length];
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean res=dfs(board,word,i,j,1,visited);
                    if(res){
                        return true;
                    }
                }
            }
         }
         return false;
    }
    public static int[] x=new int[]{0,0,-1,1};
    public static int[] y=new int[]{-1,1,0,0};
    public boolean dfs(char[][] board, String word,int i,int j,int index,boolean[][] visited){
          if(index==word.length()){
            return true;
          }
          visited[i][j]=true;
          for(int k=0;k<4;k++){
            int ni=i+x[k];
            int nj=j+y[k];
            if(ni<0 || ni>=board.length || nj<0 || nj>=board[0].length || visited[ni][nj] || board[ni][nj]!=word.charAt(index)){
                continue;
            }
            index++;
            boolean res=dfs(board,word,ni,nj,index,visited);
            if(res){
                return true;
            }
            index--;
          }
          visited[i][j]=false;
          return false;
    }
}