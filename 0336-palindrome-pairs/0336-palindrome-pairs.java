class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }

        for(int i=0;i<words.length;i++){
            String w=words[i];
            for(int j=0;j<=w.length();j++){
                String p=w.substring(0,j);
                String s=w.substring(j);

                if(isPalindrome(p)){
                    String remRev=new StringBuilder(s).reverse().toString();
                    Integer index=map.get(remRev);
                    if(index!=null && index!=i){
                        res.add(Arrays.asList(index, i));
                    }
                }

                if(j!=w.length() && isPalindrome(s)){
                    String remRev=new StringBuilder(p).reverse().toString();
                    Integer index=map.get(remRev);
                    if(index!=null && index!=i){
                        res.add(Arrays.asList(i,index));
                    }
                }
            }

        }
        return res;
    }
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}