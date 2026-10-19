
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0) {
                break;
            }
            count[sandwich]--;
        }
        return count[0] + count[1];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna