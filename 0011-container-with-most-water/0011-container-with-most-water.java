import java.lang.Math;
class Solution {
    public int maxArea(int[] height) {
         int left=0;
        int right=height.length-1;
        int max=Integer.MIN_VALUE;
        while(left<right){
            int width=(right-left);
            int hght=Math.min(height[left],height[right]);
            int area=width*hght;
            max=max<area?area:max;
            if(height[left]<height[right] && left<right){
                left++;
            }else if(height[right]<=height[left] && right>left){
                right--;
            }
        }
        return max;
    }
}