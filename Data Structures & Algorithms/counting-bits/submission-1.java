class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int offset = 1;

        for(int i = 1; i <= n; i++) {
            if(offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}
/*  
去掉MSB后剩余部分1的数量
0 0000  dp[0]
1 0001  1 + dp[1 - 1]
2 0010  1 + dp[2 - 2]
3 0011  1 + dp[3 - 2]
4 0100  1 + dp[4 - 4]
5 0101  1 + dp[5 - 4]
6 0110  1 + dp[6 - 4]
7 0111  1 + dp[7 - 4]
8 1000  1 + dp[8 - 8]
9 1001  1 + dp[9 - 8]
*/