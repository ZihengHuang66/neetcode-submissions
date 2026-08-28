class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for(int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            int tar = target - curr;
            if(list.contains(tar)) {
                result[1] = i;
                result[0] = list.indexOf(tar);
            }
        }
        return result;
    }
}
