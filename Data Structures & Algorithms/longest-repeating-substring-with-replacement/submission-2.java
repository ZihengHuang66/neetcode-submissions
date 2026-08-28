class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> currFreq = new HashMap<>();
        int longest = 0;
        int left = 0;
        int right = 0;
        currFreq.put(s.charAt(0), 1);
        
        while(right < s.length()) {
            int numReplace = (right - left + 1) - mostFreqInMap(currFreq);
            if(numReplace <= k) {
                longest = Math.max(longest, right - left + 1);
                if(right == s.length() - 1) {
                    return longest;
                }
                right++;
                char curr = s.charAt(right);
                if(currFreq.containsKey(curr)) {
                    currFreq.put(curr, currFreq.get(curr) + 1);
                } else {
                    currFreq.put(curr, 1);
                }
            } else {
                char curr = s.charAt(left);
                currFreq.put(curr, currFreq.get(curr) - 1);
                left++;
            }
        }
        return longest;
    }

    private static int mostFreqInMap(Map<Character, Integer> map) {
        int result = 0;
        for(char c : map.keySet()) {
            result = Math.max(result, map.get(c));
        }
        return result;
    }
}
