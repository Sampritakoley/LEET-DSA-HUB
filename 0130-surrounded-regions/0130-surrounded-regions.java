class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][col-1]=='O'){
                dfs(board,i,col-1);
            }
        }
        for(int i=0;i<col;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[row-1][i]=='O'){
                dfs(board,row-1,i);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }public void dfs(char[][] board, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O'){
               return;
        }
        board[i][j]='#';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna