class Solution {
    public int slidingPuzzle(int[][] board) {

        String target = "123450";

        StringBuilder sb = new StringBuilder();

        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }

        String start = sb.toString();

        int[][] neighbors = {
            {1, 3},       
            {0, 2, 4},   
            {1, 5},       
            {0, 4},      
            {1, 3, 5},    
            {2, 4}        
        };

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                if (curr.equals(target))
                    return moves;

                int zeroPos = curr.indexOf('0');

                for (int nextPos : neighbors[zeroPos]) {

                    char[] arr = curr.toCharArray();

                    char temp = arr[zeroPos];
                    arr[zeroPos] = arr[nextPos];
                    arr[nextPos] = temp;

                    String nextState = new String(arr);

                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        q.offer(nextState);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}