class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
               open++;
               sb.append(ch);
            }else if(ch==')'){
               if(open>0){
                  sb.append(ch);
                  open--;
               }
            }else{
              sb.append(ch);
            }
        }
        System.out.println(sb);
        int close=0;
        StringBuilder res=new StringBuilder();
        for(int i=sb.length()-1;i>=0;i--){
           if(sb.charAt(i)==')'){
             close++;
             res.append(sb.charAt(i));
           }else if(sb.charAt(i)=='('){
              if(close>0){
                res.append(sb.charAt(i));
                close--;
              }
           }else{
              res.append(sb.charAt(i));
           }
        }
        return res.reverse().toString();
    }
}