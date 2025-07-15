class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;

        int left = 1;
        int right = 0;

        for (int day : bloomDay) {
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                right = mid; 
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int consecutiveFlowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }

        return bouquets >= m;
    }
}