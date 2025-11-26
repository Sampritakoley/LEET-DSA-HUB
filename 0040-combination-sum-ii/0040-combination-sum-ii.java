class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> ans=new ArrayList<Integer>();
        Arrays.sort(candidates);
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
           // when i will be not the starting index then only we can compare it with the prev one
            if (i>index && candidates[i] == candidates[i - 1]) continue;
            int val=candidates[i];
            int restTarget=target-val;
            ans.add(val);
            findCombination(res, ans, candidates, restTarget, i+1);
            ans.remove(ans.size() - 1);
        }
    }
}