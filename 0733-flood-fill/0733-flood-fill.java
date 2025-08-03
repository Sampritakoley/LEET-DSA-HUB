class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc]==color) return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }public static void dfs(int[][]image,int i,int j,int c,int oldC){
         if(i<0||i>=image.length|| j<0||j>=image[0].length||image[i][j]==c||
         image[i][j]!=oldC){
              return;
         }
         image[i][j]=c;
         dfs(image,i+1,j,c,oldC);
         dfs(image,i-1,j,c,oldC);
         dfs(image,i,j+1,c,oldC);
         dfs(image,i,j-1,c,oldC);
    }
}