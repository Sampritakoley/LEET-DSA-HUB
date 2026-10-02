class Solution {
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Double> weight = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations,double[] values,List<List<String>> queries) {
        for (List<String> eq : equations) {
            String a = eq.get(0);
            String b = eq.get(1);
            parent.putIfAbsent(a, a);
            parent.putIfAbsent(b, b);
            weight.putIfAbsent(a, 1.0);
            weight.putIfAbsent(b, 1.0);
        }
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            union(a, b, values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b)) {
                ans[i] = -1.0;
                continue;
            }
            String rootA = find(a);
            String rootB = find(b);
            if (!rootA.equals(rootB)) {
                ans[i] = -1.0;
            } else {
                ans[i] = weight.get(a) / weight.get(b);
            }
        }
        return ans;
    }
    private String find(String x) {
        if (!parent.get(x).equals(x)) {
            String p = parent.get(x);
            String root = find(p);
            weight.put(x, weight.get(x) * weight.get(p));
            parent.put(x, root);
        }
        return parent.get(x);
    }
    private void union(String a, String b, double value) {
        String rootA = find(a);
        String rootB = find(b);
        if (rootA.equals(rootB)) {
            return;
        }
        parent.put(rootA, rootB);
        weight.put(rootA,value * weight.get(b) / weight.get(a));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna