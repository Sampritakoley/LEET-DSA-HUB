class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> ans=new ArrayList<Integer>();
        findCombination(res,ans,n,1,k);
        return res; 
    }public static void findCombination(List<List<Integer>> res, List<Integer> ans, int target,int index,int k){
        if(ans.size()==k){
            if(target==0){
                res.add(new ArrayList(ans));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (i > target) break;

            ans.add(i);
            findCombination(res,ans,target-i,i+1,k);
            ans.remove(ans.size() - 1);
        }
    }
}