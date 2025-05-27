class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            if(right==nums.length-1 && nums[right]<target){
                 return right+1;
            }
            if(nums[left]<target){
                left++;
            }else if(nums[left]>=target){
                return left;
            }
            else if(nums[right]>target){
                right--;
                continue;
            }else{
                return right;
            }
        }
        return -1;
    }
}