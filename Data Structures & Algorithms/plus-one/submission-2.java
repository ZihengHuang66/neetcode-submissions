class Solution {
    public int[] plusOne(int[] digits) {
        boolean reachten = false;
        if(digits[digits.length - 1] == 9) {
            reachten = true;
            digits[digits.length - 1] = 0;
        } else {
            digits[digits.length - 1] += 1;
            return digits;
        }

        if(digits.length == 1) {
            digits = addOne(digits);
            return digits;
        }

        for(int i = digits.length - 2; i >= 0; i--) {
            if(digits[i] == 9 && reachten) {
                digits[i] = 0;
                if(i == 0) {
                    digits = addOne(digits);
                }
            } else if(reachten) {
                digits[i] += 1;
                reachten = false;
            }
        }
        return digits;
    }

    private int[] addOne(int[] curr) {
        int[] res = new int[curr.length + 1];
        res[0] = 1;
        for(int i = 1; i < res.length; i++) {
            res[i] = curr[i - 1];
        }
        return res;
    }
}
