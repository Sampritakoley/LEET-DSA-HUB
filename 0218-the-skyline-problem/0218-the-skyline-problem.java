
import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Arrays.sort(buildings, (a, b) ->
            Integer.compare(a[0], b[0]));
        TreeSet<Integer> xCoords = new TreeSet<>();

        for (int[] b : buildings) {
            xCoords.add(b[0]);
            xCoords.add(b[1]);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        int prevHeight = 0;

        for (int x : xCoords) {
            while (i < buildings.length &&
                   buildings[i][0] == x) {

                int left = buildings[i][0];
                int right = buildings[i][1];
                int height = buildings[i][2];

                maxHeap.offer(new int[]{height, right});
                i++;
            }
            while (!maxHeap.isEmpty() &&
                   maxHeap.peek()[1] <= x) {
                maxHeap.poll();
            }
            int currHeight = maxHeap.isEmpty()? 0: maxHeap.peek()[0];
            if (currHeight != prevHeight) {
                result.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna