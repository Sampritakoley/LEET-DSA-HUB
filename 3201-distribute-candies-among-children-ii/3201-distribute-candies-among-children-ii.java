class Solution {
    public long distributeCandies(int n, int limit) {
        return comb(n + 2, 2)
            - 3 * comb(n - limit - 1 + 2, 2)
            + 3 * comb(n - 2 * (limit + 1) + 2, 2)
            - comb(n - 3 * (limit + 1) + 2, 2);
    }

    private long comb(int n, int k) {
        if (n < 0 || k < 0 || n < k) return 0;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res *= (n - i + 1);
            res /= i;
        }
        return res;
    }
}