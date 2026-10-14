import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> sums =
            new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                sums.add(grid[r][c]);
                for (int k = 1;r + 2 * k < m &&c - k >= 0 &&c + k < n;k++) {

                    int sum = 0;
                    for (int i = 0; i < k; i++) {
                        sum += grid[r + i][c + i];
                    }
                    for (int i = 0; i < k; i++) {
                        sum += grid[r + k + i][c + k - i];
                    }
                    for (int i = 0; i < k; i++) {
                        sum += grid[r + 2 * k - i][c - i];
                    }
                    for (int i = 0; i < k; i++) {
                        sum += grid[r + k - i][c - k + i];
                    }

                    sums.add(sum);
                }
            }
        }

        int size = Math.min(3, sums.size());
        int[] answer = new int[size];

        int i = 0;
        for (int sum : sums) {
            if (i == 3) break;
            answer[i++] = sum;
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna