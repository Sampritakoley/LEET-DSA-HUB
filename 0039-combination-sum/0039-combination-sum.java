class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> ans=new ArrayList<Integer>();
        findCombination(res,ans,candidates,target,0);
        return res; 
    }
    public static void findCombination(List<List<Integer>> res, List<Integer> ans,int[] candidates, int target,int index){
        if(target==0){
            res.add(new ArrayList<>(ans)); 
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            int val=candidates[i];
            int restTarget=target-val;
            ans.add(val);
            findCombination(res, ans, candidates, restTarget, i);
            ans.remove(ans.size() - 1);
        }
    }
}
