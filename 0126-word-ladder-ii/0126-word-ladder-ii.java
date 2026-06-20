import java.util.*;

class Solution {

    private List<List<String>> ans = new ArrayList<>();
    private Map<String, List<String>> parents = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord))
            return ans;

        Map<String, Integer> level = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        level.put(beginWord, 0);

        while (!q.isEmpty()) {

            String curr = q.poll();
            int currLevel = level.get(curr);

            char[] arr = curr.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String next = new String(arr);

                    if (!words.contains(next))
                        continue;

                    // First time visiting next
                    if (!level.containsKey(next)) {

                        level.put(next, currLevel + 1);
                        q.offer(next);

                        parents.putIfAbsent(next, new ArrayList<>());
                        parents.get(next).add(curr);
                    }
                    // Another shortest path to next
                    else if (level.get(next) == currLevel + 1) {

                        parents.get(next).add(curr);
                    }
                }

                arr[i] = original;
            }
        }

        if (!level.containsKey(endWord))
            return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, path);

        return ans;
    }

    private void dfs(String word, String beginWord, List<String> path) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);

            return;
        }

        if (!parents.containsKey(word))
            return;

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, path);

            path.remove(path.size() - 1);
        }
    }
}