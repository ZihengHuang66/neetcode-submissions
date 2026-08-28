class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] < nums[right] && nums[mid] > nums[left]) {
                return nums[left];
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
// 2 2 1