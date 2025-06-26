class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        Set<Long> candidates = new HashSet<>();

        candidates.add((long)Math.pow(10, len) + 1);
        candidates.add((long)Math.pow(10, len - 1) - 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            StringBuilder sb = new StringBuilder();
            String p = String.valueOf(i);
            sb.append(p);

            String rev = new StringBuilder(p).reverse().toString();
            if (len % 2 == 0) {
                sb.append(rev);
            } else {
                sb.append(rev.substring(1));
            }

            candidates.add(Long.parseLong(sb.toString()));
        }

        long closest = -1;
        long minDiff = Long.MAX_VALUE;

        for (long cand : candidates) {
            if (cand == num) continue;
            long diff = Math.abs(cand - num);
            if (diff < minDiff || (diff == minDiff && cand < closest)) {
                minDiff = diff;
                closest = cand;
            }
        }

        return String.valueOf(closest);
    }
}