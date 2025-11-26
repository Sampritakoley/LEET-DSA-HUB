class Solution {
    public List<String> letterCombinations(String digits) {
        String[] strarr=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> CombList=new ArrayList<String>();
        if(digits.length()==0){
            return CombList;
        }
        getCombination(CombList,digits,"",0,strarr);
        return CombList;
    }
    
    private static void getCombination(List<String> CombList,String digits,String res, int depth,String[] strarr){
        if(res.length()==digits.length()){
            CombList.add(res);
            return;
        }
        int num=digits.charAt(depth)-'0';
        String str=strarr[num];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            getCombination(CombList,digits,res+ch,depth+1,strarr);
        }
        return;
    }
}