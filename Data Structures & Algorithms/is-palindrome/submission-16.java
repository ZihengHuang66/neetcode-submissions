class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right && left < s.length() && right >= 0) {
            while(left < s.length() && !isLetter(s.toLowerCase().charAt(left))) {
                left++;
            }
            while(right >= 0 && !isLetter(s.toLowerCase().charAt(right))) {
                right--;
            }
            if(left < right && s.toLowerCase().charAt(left) != s.toLowerCase().charAt(right)) {
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
