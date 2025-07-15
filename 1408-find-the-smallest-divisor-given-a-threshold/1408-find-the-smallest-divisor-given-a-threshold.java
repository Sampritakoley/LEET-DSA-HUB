class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right=Math.max(num,right);
        } 
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (computeSum(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    private static int computeSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (int)Math.ceil((double)num/divisor);
        }
        return sum;
    }
}