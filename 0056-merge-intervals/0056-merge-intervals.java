class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int oldSt=intervals[0][0];
        int oldEd=intervals[0][1];
        ArrayList<int[]> res=new ArrayList<>();
        res.add(new int[]{oldSt,oldEd});
        
        for(int i=1;i<intervals.length;i++){
            int newSt=intervals[i][0];
            int newEd=intervals[i][1];
            if(newSt>= oldSt && newSt<=oldEd || newEd>= oldSt && newEd<=oldEd || newSt<=oldSt && newEd>=oldEd){
                res.remove(res.size()-1);
                int min=Math.min(oldSt,newSt);
                int max=Math.max(oldEd,newEd);
                oldSt=min; oldEd=max;
                res.add(new int[]{min,max});
            }else{
                 res.add(new int[]{newSt,newEd});
                 oldSt=newSt; oldEd=newEd;
            }
        }
        int[][] result=convertArrayListToIntArray(res);

        return result;

    }

    public static int[][] convertArrayListToIntArray(ArrayList<int[]> list) {
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}