class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowCount=obstacleGrid.length;
        int colCount=obstacleGrid[0].length;
        int[][] dp=new int[rowCount][colCount];
        dp[rowCount-1][colCount-1]=obstacleGrid[rowCount-1][colCount-1]==1?0:1;
        for(int i=dp[0].length-2;i>=0;i--){
            if(obstacleGrid[obstacleGrid.length-1][i]==1){
                dp[obstacleGrid.length-1][i]=0;
            }else{
                dp[obstacleGrid.length-1][i]= dp[obstacleGrid.length-1][i+1];
            }
        }
        for(int i=dp.length-2;i>=0;i--){
            if(obstacleGrid[i][obstacleGrid[0].length-1]==1){
                dp[i][obstacleGrid[0].length-1]=0;
            }else{
                dp[i][obstacleGrid[0].length-1]= dp[i+1][obstacleGrid[0].length-1];
            }
        }

        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }
}