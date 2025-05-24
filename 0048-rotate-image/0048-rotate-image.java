class Solution {
    public void rotate(int[][] matrix) {
        int top=0;int bottom=matrix.length-1;

        while(top<bottom){
            for(int i=0;i<matrix[0].length;i++){
                int temp=matrix[top][i];
                matrix[top][i]=matrix[bottom][i];
                matrix[bottom][i]=temp;
            }
            top++;
            bottom--;
        }

         for(int i=0;i<matrix[0].length;i++){
            for(int j=i+1;j<matrix.length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
}