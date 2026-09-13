class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
/*
a = 1001 = 9
b = 1011 = 11


carry = 10010
a = 0010
b = 10010


res = 10100 = 20
*/