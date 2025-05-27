class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        Set<String> uniqueSet = new HashSet<>();
        for (int element : nums) {
            intList.add(element);
        }
        findArrPermute(res, ans,uniqueSet, intList);
        return res;
    }
    public static void findArrPermute(List<List<Integer>> res,List<Integer> ans,Set<String>uniqueSet,List<Integer> que){
        if(que.size()==0){
            List<Integer> temp = new ArrayList<>(ans);
            String key = temp.toString();
            if (!uniqueSet.contains(key)) {
                uniqueSet.add(key);
                res.add(temp);
            }
        }
        for(int i=0;i<que.size();i++){
            int ch=que.get(i);
            List<Integer> leftStr=que.subList(0, i);
            List<Integer> rightStr=que.subList(i+1, que.size());
            List<Integer> newQue=new ArrayList<>();
            newQue.addAll(leftStr);
            newQue.addAll(rightStr);
            ans.add(ch);
            findArrPermute(res,ans,uniqueSet,newQue);
            ans.remove(ans.size()-1);
        }
    }
}