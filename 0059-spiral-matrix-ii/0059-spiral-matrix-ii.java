class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int count=1;
        int top=0;int bottom=n-1;int left=0;int right=n-1;
        while(true){
            for(int i=left;i<=right;i++){
                res[top][i]=count++;
            }
            top++;
            if(top>bottom){
                return res;
            }
            for(int i=top;i<=bottom;i++){
                res[i][right]=count++;
            }
            right--;
            if(left>right){
               return res;
            }
            for(int i=right;i>=left;i--){
                res[bottom][i]=count++;
            }
            bottom--;
            if(top>bottom){
                return res;
            }

            for(int i=bottom;i>=top;i--){
                res[i][left]=count++;
            }
            left++;
            if(left>right){
               return res;
            }
        }
    }
}