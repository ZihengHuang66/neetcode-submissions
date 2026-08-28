class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int target = -(nums[i]);
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                if(nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[left]);
                    curr.add(nums[right]);
                    curr.add(nums[i]);
                    result.add(curr);

                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
// -4 -1 -1 0 1 2
