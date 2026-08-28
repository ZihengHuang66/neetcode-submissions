class Solution {
    public int search(int[] nums, int target) {
        if(findCutoff(nums) != 0) {
            if(binarySearch(nums, 0, findCutoff(nums) - 1, target) == -1) {
                return binarySearch(nums, findCutoff(nums), nums.length - 1, target);
            } else {
                return binarySearch(nums, 0, findCutoff(nums) - 1, target);
            }
        } else {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
    }

    private static int findCutoff(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] <= nums[right]) {
            return left;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
