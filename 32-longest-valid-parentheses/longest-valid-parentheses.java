class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
            maxLen = Math.max(maxLen, i - stack.peek());
        }
        return maxLen;
    }
}