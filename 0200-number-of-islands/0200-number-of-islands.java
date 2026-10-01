class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int rowLen=grid.length;
        int colLen=grid[0].length;
        boolean[][] visited=new boolean[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int i, int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]!='1'){
            return;
        }
        visited[i][j]=true;
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna