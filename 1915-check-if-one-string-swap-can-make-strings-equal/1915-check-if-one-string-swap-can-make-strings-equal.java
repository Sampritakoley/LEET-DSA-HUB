class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        ArrayList<Integer> unmatchedIndex=new ArrayList<>();
        char[] sar1=s1.toCharArray();
        char[] sar2=s2.toCharArray();
        for(int i=0;i<s1.length();i++){
            if(sar1[i]!=sar2[i]){
                unmatchedIndex.add(i);
            }
        }

        if(unmatchedIndex.size()==0 ||((unmatchedIndex.size()==2) && (sar1[unmatchedIndex.get(0)]==sar2[unmatchedIndex.get(1)]) && (sar1[unmatchedIndex.get(1)]==sar2[unmatchedIndex.get(0)]))){
            return true;
        }
        return false;
    }
}