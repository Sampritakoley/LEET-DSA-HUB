import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] spf = buildSPF(max);
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int num = nums[i];

            while (num > 1) {

                int prime = spf[num];

                primeToIndices
                        .computeIfAbsent(prime, k -> new ArrayList<>())
                        .add(i);
                while (num % prime == 0) {
                    num /= prime;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        boolean[] usedPrime = new boolean[max + 1];

        queue.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int index = queue.poll();

                if (index == n - 1) {
                    return jumps;
                }
                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    queue.offer(index - 1);
                }
                if (index + 1 < n && !visited[index + 1]) {
                    visited[index + 1] = true;
                    queue.offer(index + 1);
                }
                int value = nums[index];

                if (isPrime(value, spf) && !usedPrime[value]) {

                    usedPrime[value] = true;

                    List<Integer> destinations =
                            primeToIndices.get(value);

                    if (destinations != null) {

                        for (int next : destinations) {

                            if (!visited[next]) {
                                visited[next] = true;
                                queue.offer(next);
                            }
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }
    private int[] buildSPF(int max) {

        int[] spf = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            spf[i] = i;
        }

        if (max >= 0) {
            spf[0] = 0;
        }

        if (max >= 1) {
            spf[1] = 1;
        }

        for (int i = 2; i * i <= max; i++) {

            if (spf[i] == i) { 

                for (int j = i * i; j <= max; j += i) {

                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }

    private boolean isPrime(int num, int[] spf) {
        return num >= 2 && spf[num] == num;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna