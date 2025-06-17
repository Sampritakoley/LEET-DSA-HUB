class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set=new HashSet<>();
        Queue<String> q= new LinkedList<>();
        List<String> res=new ArrayList<>();
        q.add(s);
        set.add(s);
        boolean foundOneDeep=false;
        while(!q.isEmpty()){
           String sval=q.poll();
           if(isValid(sval)){
              res.add(sval);
              foundOneDeep=true;
           }
           if(foundOneDeep){
              continue;
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
        return res;
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