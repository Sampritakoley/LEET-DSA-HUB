class Solution {
    public int maxProfit(int[] prices) {
        int minPriceToBuy=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int p=prices[i]-minPriceToBuy;
            maxProfit=maxProfit<p?p:maxProfit;
            minPriceToBuy=minPriceToBuy>prices[i]?prices[i]:minPriceToBuy;
        }
        return maxProfit;
    }
}