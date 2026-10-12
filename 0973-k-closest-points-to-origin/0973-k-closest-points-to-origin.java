class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->{
            Long distance1=(long)(a[0]*a[0])+(a[1]*a[1]);
            Long distance2=(long)(b[0]*b[0])+(b[1]*b[1]);
            return Long.compare(distance2,distance1);
        });
        for(int[] pt:points){
            maxHeap.offer(pt);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] result=new int[k][2];
        for(int i=k-1;i>=0;i--){
            int[] point=maxHeap.poll();
            result[i][0]=point[0];
            result[i][1]=point[1];
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna