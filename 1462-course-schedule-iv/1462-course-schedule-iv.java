class Solution {

    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries) {

        boolean[][] reachable =
                new boolean[numCourses][numCourses];

        for (int[] p : prerequisites) {

            int prerequisite = p[0];
            int course = p[1];

            reachable[prerequisite][course] = true;
        }

        for (int k = 0; k < numCourses; k++) {

            for (int i = 0; i < numCourses; i++) {

                for (int j = 0; j < numCourses; j++) {

                    reachable[i][j] =
                            reachable[i][j]
                            || (reachable[i][k]
                            && reachable[k][j]);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {

            int u = query[0];
            int v = query[1];

            answer.add(reachable[u][v]);
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna