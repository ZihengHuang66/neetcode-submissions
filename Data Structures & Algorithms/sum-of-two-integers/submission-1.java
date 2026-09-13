class Solution {
    public int getSum(int a, int b) {
        int carry = -1;
        while(carry != 0) {
            carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
/*
a = 1001 = 9
b = 1011 = 11


carry = 00000
a = 10000
b = 00100


res = 10100 = 20
*/