
import java.util.*;

class Solution {

    class Group {
        int start;
        int length;

        Group(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    class SparseTable {
        int[][] st;
        int[] log;
        int n;

        SparseTable(int[] arr) {
            n = arr.length;

            log = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            int levels = n == 0 ? 1 : log[n] + 1;
            st = new int[levels][n];

            if (n == 0) return;

            for (int i = 0; i < n; i++) {
                st[0][i] = arr[i];
            }

            for (int k = 1; k < levels; k++) {
                for (int j = 0; j + (1 << k) <= n; j++) {
                    st[k][j] = Math.max(
                        st[k - 1][j],
                        st[k - 1][j + (1 << (k - 1))]
                    );
                }
            }
        }

        int query(int l, int r) {
            if (l > r) return 0;

            int k = log[r - l + 1];

            return Math.max(
                st[k][l],
                st[k][r - (1 << k) + 1]
            );
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(
        String s, int[][] queries
    ) {

        int n = s.length();
        int ones = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[n];

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '0') {

                if (i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                } else {
                    zeroGroups.add(new Group(i, 1));
                }
            }

            zeroGroupIndex[i] = zeroGroups.size() - 1;
        }
        if (zeroGroups.isEmpty()) {
            List<Integer> result = new ArrayList<>();

            for (int[] q : queries) {
                result.add(ones);
            }

            return result;
        }

        int m = zeroGroups.size();
        int[] merge = new int[m - 1];

        for (int i = 0; i < m - 1; i++) {
            merge[i] =
                zeroGroups.get(i).length +
                zeroGroups.get(i + 1).length;
        }
        SparseTable st = new SparseTable(merge);

        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {

            int l = query[0];
            int r = query[1];

            int leftIndex = zeroGroupIndex[l];
            int rightIndex = zeroGroupIndex[r];

            int left = leftIndex == -1? -1: zeroGroups.get(leftIndex).length- (l - zeroGroups.get(leftIndex).start);

            int right = rightIndex == -1? -1: r - zeroGroups.get(rightIndex).start + 1;
            int start = leftIndex + 1;

            int end = (s.charAt(r) == '1')
                ? rightIndex
                : rightIndex - 1;

            int best = ones;

            if (s.charAt(l) == '0' &&
                s.charAt(r) == '0' &&
                leftIndex + 1 == rightIndex) {

                best = Math.max(
                    best,
                    ones + left + right
                );

            } 
            else if (start <= end - 1) {

                best = Math.max(
                    best,
                    ones + st.query(start, end - 1)
                );
            }
            if (s.charAt(l) == '0' &&
                leftIndex + 1 <= end) {

                best = Math.max(
                    best,
                    ones + left +
                    zeroGroups.get(leftIndex + 1).length
                );
            }
            if (s.charAt(r) == '0' &&
                leftIndex < rightIndex - 1) {

                best = Math.max(
                    best,
                    ones + right +
                    zeroGroups.get(rightIndex - 1).length
                );
            }

            ans.add(best);
        }

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna