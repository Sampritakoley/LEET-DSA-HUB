
class Solution extends SolBase {

    public int rand10() {

        while (true) {
            int a = rand7();
            int b = rand7();

            int num = (a - 1) * 7 + b;
            if (num <= 40) {
                return (num - 1) % 10 + 1;
            }
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna