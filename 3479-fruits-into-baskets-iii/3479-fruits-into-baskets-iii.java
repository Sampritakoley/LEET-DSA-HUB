class Solution {

    int[] tree;
    int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        n = baskets.length;
        tree = new int[4 * n];

        build(0, 0, n - 1, baskets);

        int unplaced = 0;

        for (int fruit : fruits) {

            int index = find(0, 0, n - 1, fruit);

            if (index == -1) {
                unplaced++;
            } else {
                update(0, 0, n - 1, index, 0);
            }
        }

        return unplaced;
    }
    private void build(int node, int start, int end, int[] baskets) {

        if (start == end) {
            tree[node] = baskets[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(2 * node + 1, start, mid, baskets);
        build(2 * node + 2, mid + 1, end, baskets);

        tree[node] = Math.max(
            tree[2 * node + 1],
            tree[2 * node + 2]
        );
    }
    private int find(int node, int start, int end, int fruit) {

        if (tree[node] < fruit) {
            return -1;
        }

        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        if (tree[2 * node + 1] >= fruit) {
            return find(
                2 * node + 1,
                start,
                mid,
                fruit
            );
        }

        return find(
            2 * node + 2,
            mid + 1,
            end,
            fruit
        );
    }
    private void update(
        int node,
        int start,
        int end,
        int index,
        int value
    ) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(2 * node + 1, start, mid, index, value);
        } else {
            update(2 * node + 2, mid + 1, end, index, value);
        }

        tree[node] = Math.max(
            tree[2 * node + 1],
            tree[2 * node + 2]
        );
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna