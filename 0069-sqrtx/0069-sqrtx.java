class Solution {
    public int mySqrt(int x) {
        int left=1;
        int right=x;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            long val=(long)mid*mid;
            if(val==x){
                ans=mid;
                return ans;
            }
            else if(val>x){
                right=mid-1;
            }else{
                ans=mid;
                left=mid+1;
            }
        }
        return ans;
    }
}