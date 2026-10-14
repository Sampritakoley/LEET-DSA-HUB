class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int n:nums){
           maxHeap.offer(n);
        }
        int first=maxHeap.poll();
        int second=maxHeap.poll();
        return (first-1)*(second-1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna