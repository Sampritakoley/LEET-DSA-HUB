class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            int j=i-1; 
            while(j>=0){
                int diff=(i-j);
                if(diff<=nums[j] && dp[j]){
                    dp[i]=true;
                    break;
                }
                j--;
            }
        }
        return dp[nums.length-1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna