class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] res=new int[2];

        while(left<=right){
            if(nums[left]==target && nums[right]==target){
                return new int[]{left,right};
            }

            if(nums[left]<target){
                left++;
            }
            if(nums[right]>target){
                right--;
            }
            
        }
        return new int[]{-1,-1};
    }
}