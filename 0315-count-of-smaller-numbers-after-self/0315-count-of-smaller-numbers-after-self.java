class Solution {

    int[] count;
    int[][] arr;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        count = new int[n];
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergeSort(0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int x : count) {
            result.add(x);
        }

        return result;
    }

    private void mergeSort(int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {

        int[][] temp = new int[right - left + 1][2];

        int i = left;
        int j = mid + 1;
        int k = 0;

        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (arr[j][0] < arr[i][0]) {

                rightCount++;

                temp[k++] = arr[j++];

            } else {

                count[arr[i][1]] += rightCount;

                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {

            count[arr[i][1]] += rightCount;

            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna