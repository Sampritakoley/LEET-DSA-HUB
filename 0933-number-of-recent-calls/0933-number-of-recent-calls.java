class RecentCounter {
    Queue<Integer> queue;
    int no_of_ping;
    public RecentCounter() {
        queue=new LinkedList<>();
        no_of_ping=0;
    }
    
    public int ping(int t) {
        queue.offer(t);
        no_of_ping++;
        while(t-queue.peek()>3000){
            no_of_ping--;
            queue.poll();
        }
        return no_of_ping;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna