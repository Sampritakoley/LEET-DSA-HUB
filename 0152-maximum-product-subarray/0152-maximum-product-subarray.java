class Solution {
    public int maxProduct(int[] nums) {
        int[]  maxdp=new int[nums.length];
        int[]  mindp=new int[nums.length];
        maxdp[0]=nums[0];
        mindp[0]=nums[0];
        if(nums.length==1){
            return nums[0];
        }
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            maxdp[i]=Math.max(Math.max(maxdp[i-1]*nums[i],nums[i]),mindp[i-1]*nums[i]);
            mindp[i]=Math.min(Math.min(mindp[i-1]*nums[i],nums[i]),maxdp[i-1]*nums[i]);
            max=Math.max(Math.max(max,maxdp[i]),mindp[i]);
        }
        return max;
    }
}