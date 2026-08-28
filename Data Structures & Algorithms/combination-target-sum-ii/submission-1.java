class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
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
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            soFar.add(nums[i]);
            combinationSum(nums, target - nums[i], i + 1, soFar, result);
            soFar.remove(soFar.size() - 1);
        }
    }
}
