class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (int element : nums) {
            intList.add(element);
        }
        findArrPermute(res, ans, intList);
        return res;
    }
    public static void findArrPermute(List<List<Integer>> res,List<Integer> ans,List<Integer> que){
        if(que.size()==0){
            res.add(new ArrayList<>(ans));
        }
        for(int i=0;i<que.size();i++){
            int ch=que.get(i);
            List<Integer> leftStr=que.subList(0, i);
            List<Integer> rightStr=que.subList(i+1, que.size());
            List<Integer> newQue=new ArrayList<>();
            newQue.addAll(leftStr);
            newQue.addAll(rightStr);
            ans.add(ch);
            findArrPermute(res,ans,newQue);
            ans.remove(ans.size()-1);
        }
    }
}