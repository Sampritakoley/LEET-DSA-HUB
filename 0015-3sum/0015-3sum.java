class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            int target=0-nums[i];
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum<target && right>left){
                    left++;
                    while(nums[left]==nums[left-1] && left<right){
                        left++;
                    }
                }else if(sum>target && right>left){
                    right--;
                    while(nums[right]==nums[right+1] && left<right){
                        right--;
                    }
                }else{
                    ArrayList<Integer> res=new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    set.add(res);
                    left++;
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
  
}