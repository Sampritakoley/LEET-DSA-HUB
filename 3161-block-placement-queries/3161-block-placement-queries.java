
import java.util.*;

class Solution {

    class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n + 5];
        }

        void update(int node, int start, int end,
                    int idx, int value) {

            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = start + (end - start) / 2;

            if (idx <= mid) {
                update(node * 2, start, mid, idx, value);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, value);
            }

            tree[node] = Math.max(
                tree[node * 2],
                tree[node * 2 + 1]
            );
        }

        int query(int node, int start, int end,
                  int l, int r) {

            if (r < start || end < l) {
                return 0;
            }

            if (l <= start && end <= r) {
                return tree[node];
            }

            int mid = start + (end - start) / 2;

            return Math.max(
                query(node * 2, start, mid, l, r),
                query(node * 2 + 1, mid + 1, end, l, r)
            );
        }

        void update(int idx, int value) {
            update(1, 0, n - 1, idx, value);
        }

        int query(int l, int r) {
            if (l > r) return 0;
            return query(1, 0, n - 1, l, r);
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        TreeSet<Integer> coordinates = new TreeSet<>();
        coordinates.add(0);

        for (int[] q : queries) {
            coordinates.add(q[1]);
        }

        List<Integer> points = new ArrayList<>(coordinates);

        int m = points.size();

        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < m; i++) {
            index.put(points.get(i), i);
        }

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        SegmentTree seg = new SegmentTree(m);
        int[] gap = new int[m];

        for (int i = 0; i < m; i++) {
            gap[i] = points.get(i) -
                     (i == 0 ? 0 : points.get(i - 1));

            seg.update(i, gap[i]);
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int x = q[1];

                Integer prev = obstacles.lower(x);
                Integer next = obstacles.higher(x);

                if (prev == null) prev = 0;

                int idx = index.get(x);
                gap[idx] = x - prev;
                seg.update(idx, gap[idx]);
                if (next != null) {
                    int nextIdx = index.get(next);

                    gap[nextIdx] = next - x;
                    seg.update(nextIdx, gap[nextIdx]);
                }

                obstacles.add(x);

            } else {

                int x = q[1];
                int sz = q[2];
                Integer last = obstacles.floor(x);
                int lastIdx = index.get(last);
                int maxGap = seg.query(0, lastIdx);
                int partialGap = x - last;

                answer.add(
                    Math.max(maxGap, partialGap) >= sz
                );
            }
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna