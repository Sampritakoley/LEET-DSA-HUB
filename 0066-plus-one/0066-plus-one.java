class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result=new ArrayList<>();
        int right=digits.length-1;
        int carry=0;
        while(right>=0){
            int sum;
            if(right==digits.length-1){
                sum=digits[right]+1+carry;
            }else{
                sum=digits[right]+carry;
            }
            carry=0;
            if(sum==10){
                result.add(0,0);
                carry=1;
            }else{
                result.add(0,sum);
            }
            right--;
        }
         
        if(carry==1){
            result.add(0,1);
        }
        int[] array = result.stream().mapToInt(Integer::intValue).toArray();
        return array;


    }
}