class Solution {
    public List<String> validStrings(int n) {
        List<String> res=new ArrayList<>();
        findSubString(n,res,"");
        return res;
    }
    public static void findSubString(int n,List<String> res,String ans){
         if(ans.length()==n){
               res.add(ans);
               return;
         }
         if(ans.length()==0||ans.charAt(ans.length()-1)!='0'){
             findSubString(n,res,ans+"0");
         }
         findSubString(n,res,ans+"1");
    }
}