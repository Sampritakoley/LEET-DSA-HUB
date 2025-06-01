class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();
        int[] nge=new int[nums.length];

        Stack<Integer> s=new Stack<>();
        s.push(nums.length-1);
        for(int i=nums.length-1;i>=0;i--){
            while(s.size()>0 && nums[s.peek()]<=nums[i]){
                s.pop();
            }
            if(s.size()==0){
                nge[i]=nums.length;
            }else{
                nge[i]=s.peek();
            }
            s.push(i);
        }


        for(int i=0;i<=nums.length-k;i++){
            int j=i;
            while(nge[j]<i+k){
                j=nge[j];
            }
            res.add(nums[j]);
        }



        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}