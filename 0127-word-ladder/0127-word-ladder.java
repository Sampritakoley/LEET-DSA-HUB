class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return 0;

        int L = beginWord.length();

        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                if (curr.equals(endWord))
                    return level;

                for (int j = 0; j < L; j++) {

                    String pattern =
                        curr.substring(0, j) + "*" + curr.substring(j + 1);

                    List<String> neighbors =
                        map.getOrDefault(pattern, new ArrayList<>());

                    for (String next : neighbors) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna