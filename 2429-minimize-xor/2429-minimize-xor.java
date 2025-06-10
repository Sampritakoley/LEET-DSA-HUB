class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits = Integer.bitCount(num2); // Number of 1s needed in x
        int x = 0;

        for (int i = 31; i >= 0 && setBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                x |= (1 << i);
                setBits--;
            }
        }

        for (int i = 0; i <= 31 && setBits > 0; i++) {
            if ((num1 & (1 << i)) == 0) {
                x |= (1 << i);
                setBits--;
            }
        }

        return x;
    }
}