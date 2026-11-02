class Solution {
    public int oddEvenJumps(int[] arr) {

        int n = arr.length;

        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];

        odd[n - 1] = true;
        even[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(arr[n - 1], n - 1);

        int result = 1;

        for (int i = n - 2; i >= 0; i--) {
            Integer higher = map.ceilingKey(arr[i]);

            if (higher != null) {
                odd[i] = even[map.get(higher)];
            }
            Integer lower = map.floorKey(arr[i]);

            if (lower != null) {
                even[i] = odd[map.get(lower)];
            }

            if (odd[i]) {
                result++;
            }
            map.put(arr[i], i);
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna