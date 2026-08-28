class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int currResult = 1;
        int left = 0; 
        int right = 0;
        Set<String> curr = new HashSet<>();
        while(right < s.length()) {
            String currString = s.substring(right, right + 1);
            curr.add(currString);
            if(curr.size() == right - left + 1) {
                currResult = curr.size();
                right++;
                if(currResult > result) {
                    result = currResult;
                }
            } else {
                currResult--;
                curr.remove(s.substring(left, left + 1));
                left++;
            }
        }
        return result;
    }
}
