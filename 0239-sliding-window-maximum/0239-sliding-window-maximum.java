class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
        int[] nge = new int[n];   
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = stack.peek();
            }

            stack.push(i);
        }

        int[] result = new int[n - k + 1];
        int j = 0;

        for (int i = 0; i <= n - k; i++) {

            if (j < i) {
                j = i;
            }

            while (nge[j] < i + k) {
                j = nge[j];
            }

            result[i] = nums[j];
        }

        return result;
    }
}