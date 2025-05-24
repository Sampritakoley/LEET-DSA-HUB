class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            if(nums[left]==target){
                return left;
            }if(nums[right]==target){
                return right;
            }

            if(nums[left]<target){
                left++;
            }
            else if(nums[right]>target){
                right--;
            }else{
                return -1;
            }
        }
        return -1;
    }
}