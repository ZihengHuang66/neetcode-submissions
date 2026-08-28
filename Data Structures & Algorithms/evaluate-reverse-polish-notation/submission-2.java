class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                if(curr.equals("+")) {
                    stack.push(a + b);
                } else if(curr.equals("-")) {
                    stack.push(b - a);
                } else if(curr.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }

        return stack.peek();
    }
}
