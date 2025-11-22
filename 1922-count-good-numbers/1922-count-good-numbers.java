class Solution {
    public static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenCount=(n+1)/2;
        long oddCount=n-evenCount;

        long evenComb=findPow(5,evenCount);
        long oddComb=findPow(4,oddCount);
        return (int)((evenComb*oddComb)% MOD);
    }public static long findPow(long x, long n){
        if(n==0){
            return 1;
        }
        long half=findPow(x, n/2);
        if(n%2==0){
            return (half*half)% MOD;
        }else{
            return (half*half*x)% MOD;
        }
    }
}
