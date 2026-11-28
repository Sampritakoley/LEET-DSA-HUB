class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        Arrays.sort(buses);
        Arrays.sort(passengers);

        int n = passengers.length;
        int j = 0;
        int remaining = 0;
        for (int bus : buses) {

            remaining = capacity;

            while (j < n && passengers[j] <= bus && remaining > 0) {
                j++;
                remaining--;
            }
        }

        int candidate;
        if (remaining > 0) {
            candidate = buses[buses.length - 1];
        }
        else {
            candidate = passengers[j - 1] - 1;
        }
        Set<Integer> occupied = new HashSet<>();

        for (int passenger : passengers) {
            occupied.add(passenger);
        }

        while (occupied.contains(candidate)) {
            candidate--;
        }

        return candidate;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna