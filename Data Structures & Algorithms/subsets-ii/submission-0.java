class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            subsetsWithDup(nums, new ArrayList<>(), result, i, 0);
        }
        return result;
    }
    private void subsetsWithDup(int[] nums, List<Integer> soFar, List<List<Integer>> result, int length, int index) {
        if(soFar.size() == length) {
            result.add(new ArrayList<>(soFar));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            soFar.add(nums[i]);
            subsetsWithDup(nums, soFar, result, length, i + 1);
            soFar.remove(soFar.size() - 1);
        }
    }
}
