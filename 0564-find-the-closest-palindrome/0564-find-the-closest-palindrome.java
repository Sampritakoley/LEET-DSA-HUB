
import java.math.BigInteger;
import java.util.*;

class Solution {

    public String nearestPalindromic(String n) {

        int len = n.length();

        int half = (len + 1) / 2;

        BigInteger original = new BigInteger(n);

        BigInteger prefix = new BigInteger(
            n.substring(0, half)
        );

        Set<BigInteger> candidates = new HashSet<>();
        candidates.add(
            BigInteger.TEN.pow(len - 1)
                .subtract(BigInteger.ONE)
        );

        candidates.add(
            BigInteger.TEN.pow(len)
                .add(BigInteger.ONE)
        );
        for (int i = -1; i <= 1; i++) {

            BigInteger newPrefix = prefix.add(
                BigInteger.valueOf(i)
            );

            String palindrome = makePalindrome(
                newPrefix.toString(),
                len
            );

            candidates.add(new BigInteger(palindrome));
        }

        BigInteger answer = null;
        BigInteger minDiff = null;

        for (BigInteger candidate : candidates) {
            if (candidate.equals(original)) {
                continue;
            }

            BigInteger diff = candidate.subtract(original).abs();

            if (minDiff == null ||
                diff.compareTo(minDiff) < 0 ||
                (diff.equals(minDiff) &&
                 candidate.compareTo(answer) < 0)) {

                minDiff = diff;
                answer = candidate;
            }
        }

        return answer.toString();
    }

    private String makePalindrome(String prefix, int len) {

        StringBuilder sb = new StringBuilder(prefix);

        int start = (len % 2 == 0)
                    ? prefix.length() - 1
                    : prefix.length() - 2;

        for (int i = start; i >= 0; i--) {
            sb.append(prefix.charAt(i));
        }

        return sb.toString();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna