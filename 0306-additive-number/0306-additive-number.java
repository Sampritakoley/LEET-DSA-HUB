import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i=1;i<=num.length()/2;i++){
            String num1=num.substring(0,i);
            if(num1.charAt(0)=='0' && num1.length()>1){
                continue;
            }
            for(int j=i+1;j<num.length();j++){
                String remaining = num.substring(j);
                String num2=num.substring(i,j);
                if (remaining.length() < Math.max(num1.length(), num2.length())) continue;

                
                if(num2.charAt(0)=='0' && num2.length()>1){
                    continue;
                }
                 
                if(isValid(num1,num2,remaining)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isValid(String num1,String num2, String rem){
        if(rem.isEmpty()){
            return true;
        }
        BigInteger n1=new BigInteger(num1);
        BigInteger n2=new BigInteger(num2);

        BigInteger sum=n1.add(n2);
        String sumStr=sum.toString();
        if(!rem.startsWith(sumStr)){
           return false;
        }
        return isValid(num2,sumStr,rem.substring(sumStr.length()));
    }
}