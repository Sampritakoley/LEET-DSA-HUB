class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
          ArrayList<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++)
        {
            HashSet<Integer> set=new HashSet<>();
            for(int j=i+1;j<nums.length;j++)
            {
               int k=-(nums[i]+nums[j]);
               if(set.contains(k))
               {
                   ArrayList<Integer> temp=new ArrayList<>();
                   temp.add(nums[i]);temp.add(nums[j]);temp.add(k);
                   Collections.sort(temp);
                   if(!containList(list, temp))
                   {
                       list.add(temp);
                   }
               }
               set.add(nums[j]);
            }
        }
        return list;
    }
    private static boolean containList(ArrayList<List<Integer>> list,ArrayList<Integer> temp)
    {
        for(List<Integer> temp_list : list)
        {
            if(temp_list.equals(temp))
            {
                return true;
            }
        }
        return false;
    }
}