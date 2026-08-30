import java.util.*;

class Solution {

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();

        int r = 1;

        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }

        FenwickTree bit = new FenwickTree(rank.size());

        Integer[] result = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {

            int currentRank = rank.get(nums[i]);
            result[i] = bit.query(currentRank - 1);
            bit.update(currentRank, 1);
        }

        return Arrays.asList(result);
    }

    static class FenwickTree {

        private int[] tree;

        FenwickTree(int size) {
            tree = new int[size + 1];
        }

        void update(int index, int delta) {

            while (index < tree.length) {

                tree[index] += delta;

                index += index & -index;
            }
        }
        int query(int index) {

            int sum = 0;

            while (index > 0) {

                sum += tree[index];

                index -= index & -index;
            }

            return sum;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna