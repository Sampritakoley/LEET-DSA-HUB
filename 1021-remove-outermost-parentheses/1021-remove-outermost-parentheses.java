class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        String res="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(count>0){
                   res+=ch;
                }
                count++;
            }else{
                count--;
                if(count>0){
                   res+=ch;
                }
            }
        }
        return res;
    }
}