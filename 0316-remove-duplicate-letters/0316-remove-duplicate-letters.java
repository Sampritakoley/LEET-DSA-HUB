class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastInd = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            lastInd[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(visited[c - 'a']) continue;

            while(!stack.isEmpty() &&
                  stack.peek() > c &&
                  lastInd[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for(char c : stack) result.append(c);

        return result.toString();
    }
}