class Solution {
    public int findPeakElement(int[] nums) {
      int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

           long leftNeighbor = (mid > 0) ? nums[mid - 1] : Long.MIN_VALUE;
            long rightNeighbor = (mid < nums.length - 1) ? nums[mid + 1] : Long.MIN_VALUE;

            // Explicit check for peak
            if (nums[mid] > leftNeighbor && nums[mid] > rightNeighbor) {
                return mid;
            }

            if (nums[mid] < rightNeighbor) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}