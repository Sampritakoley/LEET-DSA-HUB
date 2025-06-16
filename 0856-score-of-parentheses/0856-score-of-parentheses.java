class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(0);
            }else{
                int val=st.pop();
                if(val==0){
                    st.push(1);
                }else{
                    int sum=val;
                    while(!st.isEmpty() && st.peek()!=0){
                        sum+=st.pop();
                    }
                    st.pop();
                    sum=sum*2;
                    st.push(sum);
                }
            }
        }

        int total=0;
        while(!st.isEmpty()){
            total=total+st.pop();
        }
        return total;
    }
}