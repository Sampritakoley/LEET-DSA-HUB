class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] as1=s1.toCharArray();
        char[] as2=s2.toCharArray();
        Arrays.sort(as1);
        Arrays.sort(as2);
        boolean isS1Break=true;
        boolean isS2Break=true;

        for(int i=0;i<s1.length();i++){
            if(as1[i]<as2[i]){
                isS1Break=false;
            }else if(as1[i]>as2[i]){
                isS2Break=false;
            }else{
                continue;
            }
        }

        if(isS1Break || isS2Break){
            return true;
        }else{
            return false;
        }
    }
}