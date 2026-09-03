class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if(i < s.length() - 1) {
                    int curr = Integer.parseInt(s.substring(i, i + 2));
                    if(curr > 0 && curr <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }
        return dp[0];
    }
}
// 1012