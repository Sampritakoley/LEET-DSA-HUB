class Solution {
    public int maxProfit(int[] prices) {
        boolean findMin=true;boolean findMax=false; boolean profit=false;
        int min=prices[0]; int max=0; int p=0;
        for(int i=1;i<prices.length;i++){
            int val=prices[i];
            
             if(findMin){
                if(val<min){                                                      
                    min=val;
                    continue;
                }else{
                    findMin=false;
                    findMax=true;
                }
             }
             if(findMax){
                if(val>max){
                    max=val;
                    continue;
                }else{
                   p+=max-min;
                   findMax=false;
                   findMin=true;
                   min=val;
                   max=0;
                }
             }
        }
        if(findMax){
            return p+(max-min);
        }
        return p;
    }
}