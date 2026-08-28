class MyCalendar {

    private List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        for (int[] booking : bookings) {

            int existingStart = booking[0];
            int existingEnd = booking[1];

            if (startTime < existingEnd &&
                endTime > existingStart) {

                return false;
            }
        }

        bookings.add(new int[]{startTime, endTime});

        return true;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna