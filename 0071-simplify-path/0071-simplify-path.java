class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder("/");
        result.append(String.join("/", stack));

        return result.toString();
    }
}