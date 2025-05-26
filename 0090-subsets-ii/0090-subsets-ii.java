class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Set<String> uniqueSet = new HashSet<>();
        findSubset(res, list,uniqueSet, nums, 0);
        return res;
    }public static void findSubset(List<List<Integer>> res,List<Integer> list,Set<String> uniqueSet,int[] nums, int index){
        if(index==nums.length){
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            String key = temp.toString();
            if (!uniqueSet.contains(key)) {
                uniqueSet.add(key);
                res.add(temp);
            }
            return;
        }
        if(index>nums.length){
            return;
        }
        int val=nums[index];
        list.add(val);
        index=index+1;
        findSubset(res, list, uniqueSet,nums, index);
        list.remove(list.size()-1);
        index--;
        findSubset(res, list,uniqueSet, nums, index+1);
    }
}