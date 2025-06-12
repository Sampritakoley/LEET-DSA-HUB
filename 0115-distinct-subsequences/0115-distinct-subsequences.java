class Solution {
    public int numDistinct(String s, String t) {
        ArrayList<String> result=findSubsequenceLIST(s);
        int count = 0;
        for (String str : result) {
             if (t.equals(str)) {
               count++;
            }
        }
        return count;
    }public static ArrayList<String> findSubsequenceLIST(String str){
       if(str.length()==1){
           ArrayList<String> listStr=new ArrayList<>();
           listStr.add("");
           listStr.add(str);
           return listStr;
       }
       char ch=str.charAt(str.length()-1);
       String restStr=str.substring(0, str.length()-1);
       ArrayList<String> res=findSubsequenceLIST(restStr);
       ArrayList<String> restRes=new ArrayList<>();
       for(int i=0;i<res.size();i++){
          restRes.add(res.get(i)+ch);
       }
       res.addAll(restRes);
       return res;
    }
}