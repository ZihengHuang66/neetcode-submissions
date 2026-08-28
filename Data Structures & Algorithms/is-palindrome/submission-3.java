class Solution {
    public boolean isPalindrome(String s) {
        List<Character> s1 = ignoreOthers(s.toLowerCase());
        return isPalindrome(s1);
    }
    private static boolean isPalindrome(List<Character> s1) {
        if(s1.size() <= 1) {
            return true;
        } else if(s1.get(0) == s1.get(s1.size() - 1)) {
            s1.remove(0);
            s1.remove(s1.size() - 1);
            return isPalindrome(s1);
        } else {
            return false;
        }
    }

    private static List<Character> ignoreOthers(String s) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int asNum = (int) curr;
            if((asNum >= 97 && asNum <= 122) || (asNum >= 48 && asNum <= 57)) {
                list.add(curr);
            }
        }
        return list;
    }
}
