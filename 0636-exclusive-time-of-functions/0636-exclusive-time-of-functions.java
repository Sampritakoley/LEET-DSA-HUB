class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        int prevTime = 0;

        for (String log : logs) {

            String[] parts = log.split(":");

            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {

                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prevTime;
                }

                stack.push(id);
                prevTime = time;

            } else {

                result[stack.peek()] += time - prevTime + 1;

                stack.pop();

                prevTime = time + 1;
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna