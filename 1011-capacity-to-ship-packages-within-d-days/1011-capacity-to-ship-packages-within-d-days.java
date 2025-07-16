class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;int right=0;
        for(int w:weights){
            left=Math.max(left,w);
            right=right+w;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(canShip(weights,days,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static boolean canShip(int[] weight,int days, int cap){
        int totalDayNeed=1;int daycap=0;
        for(int i=0;i<weight.length;i++){
            if(daycap+weight[i]>cap){
                totalDayNeed++;
                daycap=0;
            }
            daycap+=weight[i];
        }
        return totalDayNeed<=days;
    }
}