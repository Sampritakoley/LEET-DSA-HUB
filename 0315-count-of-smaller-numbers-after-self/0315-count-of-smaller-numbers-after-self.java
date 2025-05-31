class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findInsertIndex(sorted, nums[i]);
            result.add(index);
            sorted.add(index, nums[i]);
        }

        Collections.reverse(result);
        return result;
    }

    private int findInsertIndex(List<Integer> list, int num) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}