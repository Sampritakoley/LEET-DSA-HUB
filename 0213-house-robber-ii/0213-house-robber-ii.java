class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int result1=findMaxRob(nums,0,n-1);
        int result2=findMaxRob(nums,1,n);
        return Math.max(result1,result2);
    }
    public static int findMaxRob(int[]nums, int st,int ed) {
        int pre=nums[st];
        int preNext=Math.max(nums[st+1],pre);
        for(int i=st+2;i<ed;i++){
            int val=Math.max(preNext,pre+nums[i]);
            pre=preNext;
            preNext=val;
        }
        return preNext;
    }
}