class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> intStack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
           int curr=(i==heights.length)?0:heights[i];
           while(!intStack.isEmpty() && curr<heights[intStack.peek()]){
              int height=heights[intStack.pop()];
              int width;
              if(intStack.isEmpty()){
                width=i;
              }else{
                width=i-intStack.peek()-1;
              }
              int area=height*width;
              maxArea=maxArea>area?maxArea:area;
           }
           intStack.push(i);
        }
        return maxArea;
    }
}