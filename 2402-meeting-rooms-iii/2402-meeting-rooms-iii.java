import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) ->
            Integer.compare(a[0], b[0])
        );
        PriorityQueue<Integer> available = new PriorityQueue<>();

        for (int room = 0; room < n; room++) {
            available.offer(room);
        }

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                long[] finished = busy.poll();
                available.offer((int) finished[1]);
            }

            int room;
            long actualStart;
            long actualEnd;

            if (!available.isEmpty()) {
                room = available.poll();
                actualStart = start;
                actualEnd = end;
            } else {
                long[] earliest = busy.poll();

                room = (int) earliest[1];
                actualStart = earliest[0];
                actualEnd = actualStart + duration;
            }

            count[room]++;

            busy.offer(new long[]{actualEnd, room});
        }
        int answer = 0;

        for (int room = 1; room < n; room++) {
            if (count[room] > count[answer]) {
                answer = room;
            }
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna