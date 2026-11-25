
import java.util.*;

class SnapshotArray {

    List<int[]>[] history;
    int snapId;

    public SnapshotArray(int length) {

        history = new ArrayList[length];

        for (int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
            history[i].add(new int[]{0, 0});
        }

        snapId = 0;
    }

    public void set(int index, int val) {

        List<int[]> list = history[index];
        if (list.get(list.size() - 1)[0] == snapId) {
            list.get(list.size() - 1)[1] = val;
        } else {
            list.add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {

        List<int[]> list = history[index];

        int low = 0;
        int high = list.size() - 1;

        int answer = 0;
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid)[0] <= snap_id) {

                answer = list.get(mid)[1];
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna