import java.util.*;

class Solution {

    public boolean canReach(int[] arr, int start) {

        int n = arr.length;

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int i = queue.poll();
            if (arr[i] == 0) {
                return true;
            }
            int forward = i + arr[i];

            if (forward < n && !visited[forward]) {

                visited[forward] = true;
                queue.offer(forward);
            }
            int backward = i - arr[i];

            if (backward >= 0 && !visited[backward]) {

                visited[backward] = true;
                queue.offer(backward);
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna