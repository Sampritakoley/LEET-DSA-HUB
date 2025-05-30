class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    setToZero(matrix,i,j);
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]= matrix[i][j]==-999?0:matrix[i][j];
            }
        }
    }
    public static void setToZero(int[][] matrix,int row,int col){
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i]=matrix[row][i]!=0?-999:0;
        }

        for(int i=0;i<matrix.length;i++){
            matrix[i][col]=matrix[i][col]!=0?-999:0;
        }
    }
}