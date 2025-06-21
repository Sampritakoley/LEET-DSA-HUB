class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        find(res, list, s);  
        return res;   
    }

    public static void find(List<List<String>> res, ArrayList<String> list, String Qus) {
        if (Qus.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= Qus.length(); i++) {
            String newQ = Qus.substring(i);
            String newA = Qus.substring(0, i);
            if (isPalindrome(newA)) {
                list.add(newA);
                find(res, list, newQ);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}