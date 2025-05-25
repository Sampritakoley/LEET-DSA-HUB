class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int top=0;int left=0;int right=matrix[0].length-1; int bottom=matrix.length-1;
          

        while(left<=right && top<=bottom){
            if(matrix[top][left]==target){
                return true;
            }
            if(matrix[top][left]<target){
                  
                  if(matrix[top][right]<target){
                      top++;
                  }else{
                      left++;
                  }
            }else{
                return false;
            }
        }
        return false;
        
    }
}