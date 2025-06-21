class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String sum1="";
        String sum2="";
        String sum3="";

        for(int i=0;i<firstWord.length();i++){
            sum1=sum1+(firstWord.charAt(i)-'a');
        }

        for(int i=0;i<secondWord.length();i++){
            sum2=sum2+(secondWord.charAt(i)-'a');
        }

        for(int i=0;i<targetWord.length();i++){
            sum3=sum3+(targetWord.charAt(i)-'a');
        }


        int s1=Integer.parseInt(sum1);
        int s2=Integer.parseInt(sum2);
        int s3=Integer.parseInt(sum3);

        if((s1+s2)==s3){
            return true;
        }
        return false;
    }

}