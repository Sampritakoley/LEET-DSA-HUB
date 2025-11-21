class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        findSubset(res, list, nums, 0);
        return res;
    }
     public static void findSubset(List<List<Integer>> res,List<Integer> list,int[] nums, int index){
        if(index==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        int val=nums[index];
        list.add(val);
        findSubset(res, list, nums, index+1);
        list.remove(list.size()-1);
        findSubset(res, list, nums, index+1);
    }
}