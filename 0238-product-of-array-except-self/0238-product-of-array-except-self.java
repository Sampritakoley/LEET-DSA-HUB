class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int[] res=new int[nums.length];
        int zeroCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
               prod*=nums[i];
            }else{
               zeroCount++;
            }
        }
        for(int i=0;i<res.length;i++){
            if(nums[i]!=0 && zeroCount==0){
               res[i]=prod/nums[i];
            }else if(nums[i]==0 && zeroCount==1){
                res[i]=prod;
            }else{
                res[i]=0;
            }
        }
        return res;
    }
}