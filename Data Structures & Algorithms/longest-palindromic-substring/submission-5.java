class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        int longest = 1;

        for(int i = 0; i < s.length() - 1; i++) {
            if(i > 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
                String curr = s.substring(i - 1, i + 2);
                int left = i - 2; 
                int right = i + 2;
                while(left >= 0 && right < s.length() 
                                && s.charAt(left) == s.charAt(right)) {
                    curr = s.substring(left, right + 1);
                    left--;
                    right++;
                }
                if(curr.length() > longest) {
                    res = curr;
                    longest = curr.length();
                }
            } 
            if(s.charAt(i) == s.charAt(i + 1)) {
                String curr = s.substring(i, i + 2);
                int left = i - 1;
                int right = i + 2;
                while(left >= 0 && right < s.length()
                                && s.charAt(left) == s.charAt(right)) {
                    curr = s.substring(left, right + 1);  
                    left--;
                    right++;
                }
                if(curr.length() > longest) {
                    res = curr;
                    longest = curr.length();
                }
            }
        }
        return res;
    }
}

// "acbbc"
// "abbbc"