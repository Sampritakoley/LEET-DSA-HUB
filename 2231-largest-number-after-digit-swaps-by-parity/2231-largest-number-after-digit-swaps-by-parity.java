class Solution {
    public int largestInteger(int num) {
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0)
                even.add(digit);
            else
                odd.add(digit);
        }
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        boolean flagres=true;int i=0;int j=0;
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0)
                result.append(even.get(i++));
            else
                result.append(odd.get(j++));
        }
        return Integer.parseInt(result.toString());
    }
}