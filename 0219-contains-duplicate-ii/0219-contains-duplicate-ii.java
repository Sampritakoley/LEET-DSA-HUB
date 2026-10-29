class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         Map<Integer,Integer> freq=new HashMap<>();
         int size=k+1;
         for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            if(i>size-1){
              int outgoing=nums[i-size];
              int count=freq.get(outgoing);
              if(count==1){
                freq.remove(outgoing);
              }else{
                freq.put(outgoing,count-1);
              }
            }
            if(freq.get(nums[i])>1){
                return true;
            }
         }
         return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna