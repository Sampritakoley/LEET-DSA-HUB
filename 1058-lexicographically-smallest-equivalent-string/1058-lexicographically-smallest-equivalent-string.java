class Solution {
    int[] parent = new int[26];

    public Solution() {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int root = find(ch - 'a');
            result.append((char) (root + 'a'));
        }

        return result.toString();
    }
}