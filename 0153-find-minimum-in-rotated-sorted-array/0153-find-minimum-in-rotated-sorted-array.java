class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            min=Math.min(nums[mid],min);

            if(nums[left]<=nums[mid]){
                min=Math.min(nums[left],min);
                left=mid+1;
            }else{
                min=Math.min(nums[mid+1],min);
                right=mid-1;
            }
        }
        return min;
    }
}