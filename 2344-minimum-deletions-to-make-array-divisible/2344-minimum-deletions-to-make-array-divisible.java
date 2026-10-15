
import java.util.*;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int num : numsDivide) {
            gcd = findGCD(gcd, num);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
        }
        int deletions = 0;


        while (!minHeap.isEmpty()) {
            int num = minHeap.poll();

            if (gcd % num == 0) {
                return deletions;
            }

            deletions++;
        }

        return -1;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna