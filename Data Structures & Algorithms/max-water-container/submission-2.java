class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right) {
            int currArea = Math.min(heights[left], heights[right]) * (right - left);
            if(currArea > maxArea) {
                maxArea = currArea;
            }

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
// min(height[left], height[right]) * (right - left)