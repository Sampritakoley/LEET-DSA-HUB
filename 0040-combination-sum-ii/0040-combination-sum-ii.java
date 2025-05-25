class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> ans=new ArrayList<Integer>();
        Set<String> uniqueSet = new HashSet<>();
        Arrays.sort(candidates);
        findCombination(res,ans,candidates,target,uniqueSet,0);
        return res; 
    }
    public static void findCombination(List<List<Integer>> res, List<Integer> ans,int[] candidates, int target,Set<String> uniqueSet,int index){
        if(target==0){
            List<Integer> temp = new ArrayList<>(ans);
            Collections.sort(temp);
            String key = temp.toString();
            if (!uniqueSet.contains(key)) {
                uniqueSet.add(key);
                res.add(temp);
            }
            return;
        }
        if(target<0){
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            int val=candidates[i];
            int restTarget=target-val;
            ans.add(val);
            findCombination(res, ans, candidates, restTarget,uniqueSet, i+1);
            ans.remove(ans.size() - 1);
        }
    }
}