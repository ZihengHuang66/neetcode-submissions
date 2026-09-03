class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);    // 最多用amount个硬币，所以将每个初始成amount + 1
        dp[0] = 0;  // 0元需要0个硬币
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if(dp[amount] == amount + 1) return -1;
        return dp[amount];
    }
}
// [1, 3, 4] 6