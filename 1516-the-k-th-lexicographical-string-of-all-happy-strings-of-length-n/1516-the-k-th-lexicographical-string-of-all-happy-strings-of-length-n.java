class Solution {
    int count = 0;
    String result = "";

    public String getHappyString(int n, int k) {
        backtrack(n, k, "", ' ');
        return result;
    }

    private void backtrack(int n, int k, String current, char prevChar) {
        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current;
            }
            return;
        }

        for (char c : new char[]{'a', 'b', 'c'}) {
            if (c != prevChar) {
                // Only go further if we haven't found kth string
                if (count < k) {
                    backtrack(n, k, current + c, c);
                }
            }
        }
    }
}