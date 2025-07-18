class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;

        long[] leftSum = new long[nums.length];
        long[] rightSum = new long[nums.length];

        // Left: minimize sum of first n elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalLeft = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            totalLeft += nums[i];
            if (maxHeap.size() > n) {
                totalLeft -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                leftSum[i] = totalLeft;
            }
        }

        // Right: maximize sum of last n elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long totalRight = 0;
        for (int i = nums.length - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            totalRight += nums[i];
            if (minHeap.size() > n) {
                totalRight -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                rightSum[i] = totalRight;
            }
        }

        // Find minimum difference
        long result = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            result = Math.min(result, leftSum[i] - rightSum[i + 1]);
        }

        return result;
    }
}