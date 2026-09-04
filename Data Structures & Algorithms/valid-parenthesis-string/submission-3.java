class Solution {
    public boolean checkValidString(String s) {
        // the min and max number of '(' that could be open
        int leftMin = 0;
        int leftMax = 0;

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if(curr == '(') {
                leftMin++;
                leftMax++;
            } else if(curr == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if(leftMax < 0) {
                return false;   // too many closing parentheses, not possible to recover
            }
            if(leftMin < 0) {
                leftMin = 0;    // recover it
            }
        }
        return leftMin == 0; // false if too many opening parentheses
    }
}
// (*())
// (*))