class Solution {
    public int reverseBits(int n) {
        int res = 0;
        
        for(int i = 0; i < 32; i++) {
            // figure out current bit, traverse from right to left
            int bit = (n >> i) & 1;

            //shift it and add it to result
            res += (bit << (31 - i));
        }

        return res;
    }
}
