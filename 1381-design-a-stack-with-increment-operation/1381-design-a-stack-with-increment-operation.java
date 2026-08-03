class CustomStack {

    private int[] stack;
    private int[] increment;
    private int top = -1;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        increment = new int[maxSize];
    }

    public void push(int x) {
        if (top == stack.length - 1) {
            return;
        }

        top++;
        stack[top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }

        int result = stack[top];

        result += increment[top];

        if (top > 0) {
            increment[top - 1] += increment[top];
        }

        increment[top] = 0;
        top--;

        return result;
    }

    public void increment(int k, int val) {

        if (top == -1) {
            return;
        }

        int index = Math.min(k - 1, top);

        increment[index] += val;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna