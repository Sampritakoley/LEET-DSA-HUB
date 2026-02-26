class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Pair[] arr = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            arr[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(arr);
        Stack<Pair> st=new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            Pair curr=arr[i];
            Pair p=st.peek();
            if(p.ed>=curr.st){
                if(p.ed>=curr.ed){
                    continue;
                }else{
                    st.pop();
                    st.push(new Pair(p.st,curr.ed));
                }
            }else{
                st.push(curr);
            }
        }
        Stack<Pair> rev=new Stack<>();
        while(st.size()!=0){
            rev.push(st.pop());
        }
        int[][] res=new int[rev.size()][2];
        int i=0;
        while(rev.size()!=0){
            res[i][0]=rev.peek().st;
            res[i][1]=rev.peek().ed;
            rev.pop();
            i++;
        }
        return res;
    }public static class Pair implements Comparable<Pair> {

        int st;
        int ed;

        public Pair(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Pair other) {
            return this.st - other.st;   
        }
    }
}