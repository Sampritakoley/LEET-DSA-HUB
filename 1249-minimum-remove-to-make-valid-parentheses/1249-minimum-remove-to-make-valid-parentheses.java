class Solution {
    public String minRemoveToMakeValid(String s) {
        HashSet<String> set=new HashSet<>();
        Queue<String> q= new LinkedList<>();
        q.add(s);
        set.add(s);
        while(!q.isEmpty()){
           String sval=q.poll();
           if(isValid(sval)){
             return sval;
           }

           for(int i=0;i<sval.length();i++){
              char ch=sval.charAt(i);
              if(ch!='(' && ch!=')'){
                continue;
              }
              String newVal=sval.substring(0,i)+sval.substring(i+1);
              if(!set.contains(newVal)){
                q.add(newVal);
                set.add(newVal);
              }
           }
        }
        return "";
    }

    public static boolean isValid(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
           char ch=str.charAt(i);
           if(ch=='('){
              count++;
           }else if(ch==')'){
            if(count==0){
                return false;
            }
            count--;
           }
        }
        if(count==0){
            return true;
        }else{
            return false;
        }
    }
}