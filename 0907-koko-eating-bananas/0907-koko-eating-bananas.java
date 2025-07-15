class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=findMax(piles);
        while(left<right){
            int mid=left+(right-left)/2;
            if(canEatAll(piles,h,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static boolean canEatAll(int[]  piles,int h, int k){
        int totalHours=0;
        for(int i=0;i<piles.length;i++){
            totalHours += (int)Math.ceil((double)piles[i] / k);
        }
        return totalHours<=h;
    }
    public static int findMax(int[] piles){
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            max=max>piles[i]?max:piles[i];
        }
        return max;
    }
}