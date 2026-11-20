
class Solution {
    public int flipLights(int n, int presses) {

        Set<Integer> set = new HashSet<>();
        for (int mask = 0; mask < 16; mask++) {

            int count = Integer.bitCount(mask);
            if (count % 2 != presses % 2) {
                continue;
            }
            if (count > presses) {
                continue;
            }

            int state = 0;
            for (int i = 0; i < Math.min(n, 3); i++) {

                int bulb = 1;
                if ((mask & 1) != 0) {
                    bulb ^= 1;
                }
                if ((mask & 2) != 0 && (i + 1) % 2 == 0) {
                    bulb ^= 1;
                }
                if ((mask & 4) != 0 && (i + 1) % 2 == 1) {
                    bulb ^= 1;
                }
                if ((mask & 8) != 0 && i % 3 == 0) {
                    bulb ^= 1;
                }

                state = (state << 1) | bulb;
            }

            set.add(state);
        }

        return set.size();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna