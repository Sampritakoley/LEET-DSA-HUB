class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        boolean[][] visited=new boolean[image.length][image[0].length];
        int oldC=image[sr][sc];
        dfs(image,visited,oldC,color,sr,sc);
        return image;
    }
    public void dfs(int[][] image,boolean[][] visited,int oldC,int newC,int i,int j){
        if(i<0 || j< 0 || i>= image.length || j>= image[0].length || image[i][j]!=oldC || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        image[i][j]=newC;
        dfs(image,visited,oldC,newC,i-1,j);
        dfs(image,visited,oldC,newC,i+1,j);
        dfs(image,visited,oldC,newC,i,j-1);
        dfs(image,visited,oldC,newC,i,j+1);
    }
}