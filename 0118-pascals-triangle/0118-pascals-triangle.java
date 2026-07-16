class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> list=new ArrayList<>();
        
            list.add(1);
           
            for(int j=1;j<i;j++){
                List<Integer> prev=res.get(i-1);
                list.add(prev.get(j-1)+prev.get(j));
            }

            if(i>0){
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna