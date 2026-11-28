
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>())
               .add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int target : queries) {

            List<Integer> indices = map.get(nums[target]);

            int size = indices.size();

            if (size == 1) {
                ans.add(-1);
                continue;
            }
            int low = 0;
            int high = size - 1;
            int pos = -1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (indices.get(mid) == target) {
                    pos = mid;
                    break;
                } 
                else if (indices.get(mid) < target) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
            int prev = indices.get((pos - 1 + size) % size);
            int next = indices.get((pos + 1) % size);
            int d1 = (target - prev + n) % n;
            int d2 = (next - target + n) % n;

            ans.add(Math.min(d1, d2));
        }

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna