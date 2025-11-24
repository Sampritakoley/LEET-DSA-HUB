class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int[] precompute=new int[nums.length];
        precompute[0]=1;
        for(int i=1;i<nums.length;i++){
            precompute[i]=(precompute[i-1]*2)%mod;
        }

        int left=0;
        int right=nums.length-1;
        int res=0;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                res+=(precompute[right-left])%mod;
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}