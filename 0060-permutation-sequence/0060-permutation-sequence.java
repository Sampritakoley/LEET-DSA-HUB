class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        int fact = 1;

        for(int i = 1; i <= n; i++) {
            numbers.add(i);

            if(i < n)
                fact *= i;
        }
        k--;

        StringBuilder ans = new StringBuilder();

        for(int i = n; i > 0; i--) {
            int index = k / fact;
            ans.append(numbers.get(index));
            numbers.remove(index);
            k = k % fact;
            if(i > 1)
                fact = fact / (i - 1);
        }

        return ans.toString();
    }
}