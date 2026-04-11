class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            count[i] = 1;
        }
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                    else if (len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                result += count[i];
            }
        }
        return result;
    }
}