class Solution {
    public int[] twoSum(int[] nums, int target) {
       
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
          int desiredNumber=target-nums[i];
          if(map.containsKey(desiredNumber)){
              return new int[]{i,map.get(desiredNumber)};
          }else{
            map.put(nums[i],i);
          }
       }
       return new int[]{0,0};
    }
}