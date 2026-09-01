class Solution {
    public int jump(int[] nums) {
        int right = 0;
        int count = 0;
        int max = 0;

        while(right < nums.length - 1) {
            int step = nums[right];
            int start = right;
            if(right + step >= nums.length - 1) {
                return count + 1;
            }
            for(int i = start + 1; i <= start + step; i++) {
                if(i + nums[i] > max) {
                    max = i + nums[i];
                    right = i;
                }
            }
            count++;
        }
        return count;
    }
}
