class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> listStr=new ArrayList<>();
        String str="";
        generateParenthesis(0,0,n,str,listStr);
        return listStr;
    }
    private static void generateParenthesis(int opencount,int closecount,int n,String str,List<String> listStr) {
        if(opencount==n && closecount==n){
           listStr.add(str);
           return;
        }
        if(opencount<n){
            generateParenthesis(opencount+1,closecount,n,str+"(",listStr);     
        }if(closecount<opencount){
            generateParenthesis(opencount, closecount+1, n, str+")", listStr);
        }
        return;
    }
}