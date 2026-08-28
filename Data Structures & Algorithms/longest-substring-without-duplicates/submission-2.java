class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int currResult = 1;
        int left = 0; 
        int right = 0;
        Set<String> curr = new HashSet<>();
        while(right < s.length()) {
            curr.add(s.substring(right, right + 1));
            if(curr.size() == right - left + 1) {
                currResult = curr.size();
                right++;
                if(currResult > result) {
                    result = currResult;
                }
            } else {
                currResult = 1;
                left++;
                right = left;
                curr.clear();
            }
        }
        return result;
    }
}
