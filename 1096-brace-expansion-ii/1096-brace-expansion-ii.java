import java.util.*;

class Solution {

    private String expression;
    private int index;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;

        Set<String> result = parseExpression();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    private Set<String> parseExpression() {

        Set<String> result = parseTerm();

        while (index < expression.length()
                && expression.charAt(index) == ',') {

            index++; 

            Set<String> next = parseTerm();

            result.addAll(next); 
        }

        return result;
    }

    private Set<String> parseTerm() {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < expression.length()
                && expression.charAt(index) != ','
                && expression.charAt(index) != '}') {

            Set<String> next = parseFactor();

            result = multiply(result, next); 
        }

        return result;
    }

    private Set<String> parseFactor() {

        if (expression.charAt(index) == '{') {

            index++; 

            Set<String> result = parseExpression();

            index++; 
            return result;
        }
        char ch = expression.charAt(index);
        index++;

        Set<String> result = new HashSet<>();
        result.add(String.valueOf(ch));

        return result;
    }

    private Set<String> multiply(Set<String> first,
                                 Set<String> second) {

        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna