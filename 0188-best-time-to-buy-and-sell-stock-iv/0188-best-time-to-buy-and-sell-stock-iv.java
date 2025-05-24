class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] minPrice=new int[k];
        int[] maxProfit=new int[k];
        for(int i=0;i<k;i++){
            minPrice[i]=Integer.MAX_VALUE;
            maxProfit[i]=0;
        }
        for(int i=0;i<prices.length;i++){
            int j=0;
            while(j<k){
                int m=0;
                if(j>0){
                  m=maxProfit[j-1];
                }
                minPrice[j]=Math.min(minPrice[j],prices[i]-m);
                maxProfit[j]=Math.max(maxProfit[j],prices[i]-minPrice[j]);
                j++;
            }
        }
        return maxProfit[k-1];
    }
}