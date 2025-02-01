class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        for(int x=0;x<nums.length-3;x++){
           for(int i=x+1;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            int tar=target-(nums[i]+nums[x]);
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum<tar && right>left){
                    left++;
                }else if(sum>tar && right>left){
                    right--;
                }else{
                    ArrayList<Integer> res=new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    res.add(nums[x]);
                    set.add(res);
                    left++;
                    right--;
                }
            }
        }
       }
        
        return new ArrayList<>(set);
    }
}