class Solution {
    static final long NEG = Long.MIN_VALUE / 4;
    static final int MOD = 1_000_000_007;

    class Node {
        long[][] dp = new long[2][2];
        Node() {
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    dp[i][j] = NEG;
        }
    }

    Node[] seg;
    int n;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        n = nums.length;
        seg = new Node[4 * n];
        build(1, 0, n - 1, nums);

        long ans = 0;
        for (int[] q : queries) {
            update(1, 0, n - 1, q[0], q[1]);
            Node root = seg[1];

            long best = 0;
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    best = Math.max(best, root.dp[i][j]);

            ans = (ans + best) % MOD;
        }
        return (int) ans;
    }

    void build(int idx, int l, int r, int[] nums) {
        seg[idx] = new Node();
        if (l == r) {
            seg[idx].dp[0][0] = 0;
            seg[idx].dp[1][1] = Math.max(nums[l], 0);
            return;
        }
        int mid = (l + r) / 2;
        build(idx * 2, l, mid, nums);
        build(idx * 2 + 1, mid + 1, r, nums);
        seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
    }

    void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = new Node();
            seg[idx].dp[0][0] = 0;
            seg[idx].dp[1][1] = Math.max(val, 0);
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(idx * 2, l, mid, pos, val);
        else update(idx * 2 + 1, mid + 1, r, pos, val);

        seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
    }

    Node merge(Node left, Node right) {
        Node res = new Node();
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                if (left.dp[a][b] == NEG) continue;
                for (int c = 0; c <= 1; c++) {
                    for (int d = 0; d <= 1; d++) {
                        if (right.dp[c][d] == NEG) continue;
                        if (b == 1 && c == 1) continue;
                        res.dp[a][d] = Math.max(
                            res.dp[a][d],
                            left.dp[a][b] + right.dp[c][d]
                        );
                    }
                }
            }
        }
        return res;
    }
}
