class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--) {
            for(String word : wordDict) {
                if(i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    /* we have contiguous solutions from this index! but remember to check 
                       if we have any solutions at the index after current substring */
                    dp[i] = dp[i + word.length()];
                }
                /* if we have a solution, that means we are good to continue, there is 
                   no need to check other words; more importantly, we may encounter a
                   situation where there is no matching words after current substring;
                   we only need to be sure there EXIST a solution at this point */
                if(dp[i]) break;        
            }
        }
        return dp[0];
    }
}
