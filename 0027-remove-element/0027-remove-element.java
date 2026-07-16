class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;int j=-1;
        for(int x=0;x<n;x++){
            if(nums[x]==val){
               j=x;
               break;
            }
        }

        if(j==-1){
            return n;
        }

        int i=j+1;
        while(i<n){
            if(nums[i]!=val){
                nums[j]=nums[i];
                i++;j++;
            }else{
                i++;
            }
        }
        return j;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna