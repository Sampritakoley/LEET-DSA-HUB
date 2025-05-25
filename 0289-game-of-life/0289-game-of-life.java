class Solution {
    public void gameOfLife(int[][] board) {
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                CounterResult res=findAdjacentVal(board,i,j);
                if(board[i][j]==0){
                   if(res.oneCount==3){
                    board[i][j]=-1;
                   }
                }else{
                    if(res.oneCount<2){
                        board[i][j]=-2;
                    }else if(res.oneCount==2||res.oneCount==3){
                        board[i][j]=1;
                    }else if(res.oneCount>3){
                        board[i][j]=-2;
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-1){
                    board[i][j]=1;
                }else if(board[i][j]==-2){
                     board[i][j]=0;
                }
            }
        }
    }
     
     public static class CounterResult {
        public int zeroCount;
        public int oneCount;
    }
    //dead to alive->-1   live to dead->-2
    public static CounterResult findAdjacentVal(int[][] board,int i,int j){
         CounterResult res=new CounterResult();
         int[] x=new int[]{-1,-1,0,1,1,1,0,-1};
         int[] y=new int[]{0,1,1,1,0,-1,-1,-1};
    
         for(int k=0;k<8;k++){
            if(i+x[k]<0 || j+y[k]<0 ||i+x[k]>=board.length ||j+y[k]>=board[0].length){
                continue;
            }


            int val=board[i+x[k]][j+y[k]];
            if(val==0 || val==-1){
                res.zeroCount++;
            }else{
                res.oneCount++;
            }
         }
         return res;
    }
}