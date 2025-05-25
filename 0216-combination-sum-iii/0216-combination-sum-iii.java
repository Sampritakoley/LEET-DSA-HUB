class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> ans=new ArrayList<Integer>();
        Set<String> uniqueSet = new HashSet<>();
        findCombination(res,ans,n,uniqueSet,1,k);
        return res; 
    }public static void findCombination(List<List<Integer>> res, List<Integer> ans, int target,Set<String> uniqueSet,int index,int k){
        if(target==0 && ans.size()==k){
            List<Integer> temp = new ArrayList<>(ans);
            Collections.sort(temp);
            String key = temp.toString();
            if (!uniqueSet.contains(key)) {
                uniqueSet.add(key);
                res.add(temp);
            }
            return;
        }
        if(ans.size()>k){
            return;
        }
        if(target<0){
            return;
        }

        for(int i=index;i<=9;i++){
            int restTarget=target-i;
            ans.add(i);
            findCombination(res, ans, restTarget,uniqueSet, i+1,k);
            ans.remove(ans.size() - 1);
        }
    }
}