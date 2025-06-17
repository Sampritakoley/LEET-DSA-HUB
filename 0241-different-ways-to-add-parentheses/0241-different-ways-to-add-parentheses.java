class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch=='+'||ch=='*'||ch=='-'){
                List<Integer> left=diffWaysToCompute(expression.substring(0,i));
                List<Integer> right=diffWaysToCompute(expression.substring(i+1));

                 for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') res.add(l + r);
                        else if (ch == '-') res.add(l - r);
                        else res.add(l * r);
                    }
                }
            }


        }

        //base when res will be return after finding no op
        if(res.isEmpty()){
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}