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
    public void solve(char[][] board) {
        Queue<Pair> q=new LinkedList<>();
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                q.offer(new Pair(i,0));
                board[i][0] = 'S';
            }
            if(board[i][m-1]=='O'){
                q.offer(new Pair(i,m-1));
                board[i][m-1] = 'S';
            }
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                q.offer(new Pair(0,j));
                board[0][j] = 'S';
            }if(board[n-1][j]=='O'){
               q.offer(new Pair(n-1,j));
               board[n-1][j] = 'S';
            }
        }

        while(q.size()>0){
            Pair p=q.poll();
            
            
            for(int k=0;k<4;k++){
                int newR=p.row+x[k];
                int newC=p.col+y[k];

                if(newR>=0 && newC>=0 && newR<n && newC<m && board[newR][newC]=='O'){
                    q.offer(new Pair(newR,newC));
                    board[newR][newC]='S';
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }
        return;

    }
}