class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            String str=operations[i];
            if(str.equals("C")){
                st.pop();
            }else if(str.equals("D")){
                st.push(2*st.peek());
            }else if(str.equals("+")){
                int a=st.pop();
                int b=st.peek();
                st.push(a);
                st.push(a+b);
            }else{
                int num=Integer.parseInt(str);
                st.push(num);
            }
        }

        int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna