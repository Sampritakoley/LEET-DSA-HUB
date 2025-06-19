class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }

        if(s.equals(goal)){
            HashSet<Character> set=new HashSet<>();
            for(int i=0;i<s.length();i++){
                if(set.contains(s.charAt(i))){
                    return true;
                }
                set.add(s.charAt(i));
            }
            return false;
        }else{
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=goal.charAt(i)){
                    list.add(i);
                }
            }

            if(list.size()==2  && s.charAt(list.get(0))==goal.charAt(list.get(1)) && s.charAt(list.get(1))==goal.charAt(list.get(0))){
                return true;
            }else{
                return false;
            }
        }
    }
}