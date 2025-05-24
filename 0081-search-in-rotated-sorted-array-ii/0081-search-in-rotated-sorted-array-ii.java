class Solution {
    public boolean search(int[] nums, int target) {
         int left=0;
        int right=nums.length-1;

        while(left<=right){
            if(nums[left]==target){
                return true;
            }if(nums[right]==target){
                return true;
            }

            if(nums[left]<target){
                left++;
            }
            else if(nums[right]>target){
                right--;
            }else{
                return false;
            }
        }
        return false;
    }
}