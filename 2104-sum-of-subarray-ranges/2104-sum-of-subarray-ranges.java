class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long minSum = 0, maxSum = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? mid + 1 : mid - stack.peek();
                int right = i - mid;
                minSum += (long) nums[mid] * left * right;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? mid + 1 : mid - stack.peek();
                int right = i - mid;
                maxSum += (long) nums[mid] * left * right;
            }
            stack.push(i);
        }

        return maxSum - minSum;
    }
}