class Solution {
    public int findMin(int[] nums) {    // a better version
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated at all
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right element, 
            // the minimum must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // If mid element is less than or equal to right element,
            // the minimum is at mid or to the left of mid
            else {
                right = mid;
            }
        }
        
        // left and right will converge to the minimum element
        return nums[right];
    }
}
