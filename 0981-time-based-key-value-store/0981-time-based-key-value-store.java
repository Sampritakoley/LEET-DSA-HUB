
class TimeMap {

    Map<String, List<Integer>> timestamps;
    Map<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        timestamps.computeIfAbsent(key, k -> new ArrayList<>())
                  .add(timestamp);

        values.computeIfAbsent(key, k -> new ArrayList<>())
              .add(value);
    }

    public String get(String key, int timestamp) {

        if (!timestamps.containsKey(key)) {
            return "";
        }

        List<Integer> times = timestamps.get(key);
        List<String> vals = values.get(key);

        int left = 0;
        int right = times.size() - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (times.get(mid) <= timestamp) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans == -1 ? "" : vals.get(ans);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna