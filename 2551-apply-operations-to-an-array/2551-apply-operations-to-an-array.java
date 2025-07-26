import java.util.*;

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Step 1: Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Move non-zero elements to the front
        int[] result = new int[n];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        return result;
    }
}
