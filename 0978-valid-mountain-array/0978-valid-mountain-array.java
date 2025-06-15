class Solution {
    public boolean validMountainArray(int[] arr) {
         if(arr.length<3){
            return false;
        }

        for(int i=1;i<arr.length-1;i++){
              int left=i;
              int right=i;
              boolean res=true;
              while(left>0){
                if(arr[left]>arr[left-1]){
                    left=left-1;
                }else{
                    res=false;
                    break;
                }
              }

               while(right<arr.length-1){
                if(arr[right]>arr[right+1]){
                    right=right+1;
                }else{
                    res=false;
                    break;
                }
              }

              if(res){
                return res;
              }
        }
        return false;
    }
}