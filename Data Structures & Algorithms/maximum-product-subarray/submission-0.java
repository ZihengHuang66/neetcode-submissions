class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = 1;
        int max = 1;

        for(int num : nums) {
            int temp = max * num;
            max = Math.max(num, Math.max(temp, num * min));
            min = Math.min(num, Math.min(temp, num * min));
            res = Math.max(res, max);
        }
        return res;
    }
}
// -1 -2 -3 -4
// -5 4 3 2