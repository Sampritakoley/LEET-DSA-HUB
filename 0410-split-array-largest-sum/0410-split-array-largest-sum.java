class Solution {
    public int splitArray(int[] nums, int k) {
        int low = getMax(nums);
        int high = getSum(nums);
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int splits = 1;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                splits++;
                currentSum = num;
                if (splits > k) return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) max = Math.max(max, num);
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }
}