class Solution {

    public int minimumTime(
            int n,
            int[][] relations,
            int[] time) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];

        for (int[] relation : relations) {

            int prerequisite = relation[0];
            int course = relation[1];

            graph[prerequisite].add(course);

            indegree[course]++;
        }
        int[] finishTime = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {

            if (indegree[i] == 0) {

                queue.offer(i);
                finishTime[i] = time[i - 1];
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {

            int current = queue.poll();

            answer = Math.max(answer, finishTime[current]);

            for (int next : graph[current]) {

        
                finishTime[next] = Math.max(
                        finishTime[next],
                        finishTime[current] + time[next - 1]
                );

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna