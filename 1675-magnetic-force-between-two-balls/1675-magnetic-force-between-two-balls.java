class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=0;
        int high=position[position.length-1]-position[0];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPlace(position,m,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }public static boolean canPlace(int[] position,int m,int Distance){
        int lastPosition=position[0];
        int i=1;
        int balls=m-1;
        while(i<position.length && balls>0){
            if(position[i]-lastPosition>=Distance){
                balls=balls-1;
                lastPosition=position[i];
            }
            i++;
        }
        return balls==0;
    }
}