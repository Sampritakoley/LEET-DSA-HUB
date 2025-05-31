class Solution {
    public String minWindow(String s, String t) {
       HashMap<Character,Integer> tmap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i), tmap.get(t.charAt(i))+1);
            }else{
                tmap.put(t.charAt(i), 1);
            }
        }
        int totalSum = tmap.values().stream().mapToInt(Integer::intValue).sum();
        String res="";int min=Integer.MAX_VALUE;
        HashMap<Character,Integer> smap=new HashMap<>();
        int left=0;int right=left;int matchVal=0; int matchKey=0;
        while(right<s.length()){
           char ch=s.charAt(right);
           if(tmap.containsKey(ch)){
               if(smap.containsKey(ch)){
                   matchVal=tmap.get(ch)>smap.get(ch)?matchVal+1:matchVal;
                   smap.put(ch, smap.get(ch)+1);
               }else{
                smap.put(ch, 1);
                matchKey++;
                matchVal++;
               }
           }
            while(matchVal>=totalSum && matchKey==tmap.size() && left<=right){
                    char ch1=s.charAt(left);
                    if(tmap.containsKey(ch1)){
                        if(smap.containsKey(ch1) && smap.get(ch1)>1){
                        smap.put(ch1, smap.get(ch1)-1);
                        if(smap.get(ch1)<tmap.get(ch1)){
                           matchVal--;
                        }
                        }else if(smap.containsKey(ch1) && smap.get(ch1)==1){
                        smap.remove(ch1);
                        matchVal--;
                        matchKey--;
                        }
                    }
                res=min>=s.substring(left, right+1).length()?s.substring(left, right+1):res;
                min=res.length();
                left++;
            }
           right++;

        }
        return res;
    }
}