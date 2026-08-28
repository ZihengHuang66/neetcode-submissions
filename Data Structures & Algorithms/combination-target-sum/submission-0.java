class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(nums, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void combinationSum(int[] nums, int target, int start, List<Integer> soFar, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(soFar));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            soFar.add(nums[i]);
            combinationSum(nums, target - nums[i], i, soFar, result);
            soFar.remove(soFar.size() - 1);
        }
    }
}
