class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int total = 1;
        int tempTotal = 1;
        int zeroCount = 0;

        for(int i = 0; i < nums.length; i++) {
            total *= nums[i];
            if(nums[i] != 0) {
                tempTotal *= nums[i];
            } else {
                zeroCount ++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(zeroCount <= 1) {
                if(nums[i] != 0) {
                    result[i] = total / nums[i];
                } else {
                    result[i] = tempTotal;
                }
            }
        }

        return result;
    }
}  
