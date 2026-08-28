class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while(left < right) {
            while(left < s.length() && !isLetter(s.charAt(left))) {
                left++;
            }
            while(right >= 0 && !isLetter(s.charAt(right))) {
                right--;
            }
            if(left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }

    private static boolean isLetter(char c) {

        return ((int) c >= 97 && (int) c <= 122) || ((int) c >= 48 && (int) c <= 57);
    }
}
