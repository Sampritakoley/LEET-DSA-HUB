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
            opencount++;
            str=str+'(';
            generateParenthesis(opencount,closecount,n,str,listStr);
            opencount--;
            str = str.substring(0, str.length() - 1);
        }if(closecount<opencount){
            str=str+')';
            closecount++;
            generateParenthesis(opencount, closecount, n, str, listStr);
            str = str.substring(0, str.length() - 1);
            closecount--;
        }
        return;
    }
}