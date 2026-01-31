class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res=new ArrayList<>();
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }
        int[] dp=new int[nums.length];int val=0;
        dp[0]=1;int ind=0;int maxLngth=0;int maxind=0;
        for(int i=1;i<nums.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[i]% nums[j]==0 || nums[j]%nums[i]==0){
                    max=max<dp[j]?dp[j]:max;
                }
            }
            dp[i]=max+1;
            if(maxLngth<dp[i]){
                maxLngth=dp[i];
                maxind=i;
                val=nums[i];
            }
        }
        int len=maxLngth-1;
        ind=maxind-1;
        res.add(val);
        while(ind>=0){
            if(dp[ind]==len && (nums[ind]%val==0|| val%nums[ind]==0)){
                res.add(nums[ind]);
                len--;
                val=nums[ind];
            }
            ind--;
        }

        Collections.reverse(res);
        return res;
    }
}