import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000"))
            return -1;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String curr = q.poll();

                if (curr.equals(target))
                    return moves;

                for (String next : getNeighbors(curr)) {

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private List<String> getNeighbors(String state) {

        List<String> neighbors = new ArrayList<>();

        char[] arr = state.toCharArray();

        for (int i = 0; i < 4; i++) {

            char original = arr[i];

            arr[i] = (char) ((original - '0' + 1) % 10 + '0');
            neighbors.add(new String(arr));

            arr[i] = (char) ((original - '0' + 9) % 10 + '0');
            neighbors.add(new String(arr));

            arr[i] = original;
        }

        return neighbors;
    }
}