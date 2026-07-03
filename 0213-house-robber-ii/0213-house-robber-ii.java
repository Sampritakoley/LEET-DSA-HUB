class Solution {
    public int rob(int[] nums) {
        int n=nums.length;int robHouse2=0;
        int robHouse1=findMaxRobbedAmt(nums,0,n-1);
        if(n>=2){
            robHouse2=findMaxRobbedAmt(nums,1,n);
        }
        return Math.max(robHouse1,robHouse2);
    }public int findMaxRobbedAmt(int[] nums,int st,int ed){
        int len=nums.length-1;
        int prev2=nums[st];
        int prev1=nums[st];
        if(len>1){
           prev1=Math.max(nums[st],nums[st+1]);
        }else{
            return prev2;
        }
        
        for(int i=st+2;i<ed;i++){
            int current=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}