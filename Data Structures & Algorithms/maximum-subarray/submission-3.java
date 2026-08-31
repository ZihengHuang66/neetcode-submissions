class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int res = Integer.MIN_VALUE;    //此处是因为可能出现很多负数干扰
        int currSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if(currSum > res) {
                res = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return res;
    }
}
