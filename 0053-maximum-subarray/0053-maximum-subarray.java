class Solution {
    public int maxSubArray(int[] nums) {
        int currMax=nums[0];
        int overallMax=nums[0];
        for(int i=1;i<nums.length;i++){
            int sum=currMax+nums[i];
            if(sum>=nums[i]){
                currMax=sum;
            }else{
                currMax=nums[i];
            }
            if(overallMax<=currMax){
                overallMax=currMax;
            }
        }
        return overallMax;
    }
}