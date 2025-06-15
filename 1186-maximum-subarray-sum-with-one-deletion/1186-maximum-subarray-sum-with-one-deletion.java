class Solution {
    public int maximumSum(int[] arr) {

        int noDel=arr[0];
        int oneDel=0;
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
           oneDel=Math.max(oneDel+arr[i],noDel);
           noDel=Math.max(noDel+arr[i],arr[i]);
           max=Math.max(Math.max(oneDel,noDel),max);
        }
        return max;
    }
}