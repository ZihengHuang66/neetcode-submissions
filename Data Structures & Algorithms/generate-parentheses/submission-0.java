class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, 0, 0, "", result);
        return result;
    }
    private void helper(int n, int open, int close, String curr, List<String> result) {
        if(close > open || open > n || close > n) {
            return;
        }
        if(curr.length() == 2 * n && open == close) {
            result.add(curr);
            return;
        }
        helper(n, open + 1, close, curr + "(", result);
        helper(n, open, close + 1, curr + ")", result);
    }
}
