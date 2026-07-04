class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        int[] diff=new int[n-1];
        for(int i=0;i<n-1;i++){
            diff[i]=nums[i+1]-nums[i];
        }
        if(n==1){
            return 1;
        }
        int[] dp=new int[n-1];
        dp[0]= diff[0]==0?0:1;
        int max=dp[0];
        for(int i=1;i<diff.length;i++){
            if(diff[i]==0){
                continue;
            }
            dp[i] = 1;
            int j=i-1;
            int number=diff[i];
            while(j>=0){
                if(number<0 && diff[j]>0 || number>0 && diff[j]<0){
                   dp[i]=Math.max(dp[i],dp[j]+1);
                }
                j--;
            }
            max=Math.max(dp[i],max);
        }
        return max+1;
    }
}