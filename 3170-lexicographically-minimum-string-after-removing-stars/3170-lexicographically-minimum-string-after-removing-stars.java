class Solution {
    public String clearStars(String s) {
       List<Character> stack = new ArrayList<>();
        TreeMap<Character, Deque<Integer>> charPos = new TreeMap<>();

        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.add(c);
                charPos.putIfAbsent(c, new ArrayDeque<>());
                charPos.get(c).addLast(stack.size() - 1);
            } else {
                if (!charPos.isEmpty()) {
                    char minChar = charPos.firstKey();
                    Deque<Integer> indices = charPos.get(minChar);
                    int removeIndex = indices.pollLast();

                    stack.set(removeIndex, null);

                    if (indices.isEmpty()) {
                        charPos.remove(minChar);
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character ch : stack) {
            if (ch != null) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}