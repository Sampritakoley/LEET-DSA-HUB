class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses,
                                             int[][] prerequisites,
                                             int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        boolean[][] pre = new boolean[numCourses][numCourses];

        for (int[] edge : prerequisites) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;

            pre[u][v] = true;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int next : graph.get(curr)) {

                for (int i = 0; i < numCourses; i++) {

                    if (pre[i][curr]) {
                        pre[i][next] = true;
                    }
                }

                indegree[next]--;

                if (indegree[next] == 0)
                    q.offer(next);
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] qy : queries) {
            ans.add(pre[qy[0]][qy[1]]);
        }

        return ans;
    }
}