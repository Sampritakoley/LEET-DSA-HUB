class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] freq=new int[s.length()+1][26];

        for(int i=0;i<s.length();i++){
           for(int j=0;j<26;j++){
               freq[i+1][j]=freq[i][j];
           }
           freq[i+1][s.charAt(i) - 'a']++;
        }
            List<Boolean> result = new ArrayList<>();


        for(int[] q:queries){
            int left=q[0];
            int right=q[1];
            int k=q[2];
            int oddcount=0;

            for(int i=0;i<26;i++){
                int occ=freq[right+1][i]-freq[left][i];
                if(occ%2!=0){
                    oddcount++;
                }
            }
            result.add(oddcount / 2 <= k);

        }
        return result;
    }
}