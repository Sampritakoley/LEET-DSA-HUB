
import java.util.*;

class Solution {

    public int minOperations(int[] nums) {

        int MAX = 200000;
        boolean[] isPrime = new boolean[MAX + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (i % 2 == 0) {
                int left = 0;
                int right = primes.size() - 1;

                while (left < right) {

                    int mid = left + (right - left) / 2;

                    if (primes.get(mid) >= num) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                ans += primes.get(left) - num;
            }

            else {
                if (isPrime[num]) {

                    if (num == 2) {
                        ans += 2;
                    } else {
                        ans += 1;
                    }
                }
            }
        }

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna