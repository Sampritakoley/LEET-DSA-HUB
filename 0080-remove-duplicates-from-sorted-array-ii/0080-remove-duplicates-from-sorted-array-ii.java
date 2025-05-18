class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]==nums[j]){
                count++;
                continue;
            }else{
                if(count>=2){
                    nums[i+1]=nums[i];
                    nums[i+2]=nums[j];
                    i=i+2;
                }else{
                    nums[i+1]=nums[j];
                    i=i+1;
                }
                count=1;
            }
        }
        if(count>=2){
            nums[i+1]=nums[i];
            return i+2;
        }
        return i+1;
    }
}