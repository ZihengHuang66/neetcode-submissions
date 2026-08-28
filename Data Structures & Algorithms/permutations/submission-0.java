class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), result);
        return result;
    }
    public void permute(int[] nums, List<Integer> soFar, List<List<Integer>> result) {
        if(soFar.size() == nums.length) {
            result.add(new ArrayList<>(soFar));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(soFar.contains(nums[i])) {
                continue;
            }
            soFar.add(nums[i]);
            permute(nums, soFar, result);
            soFar.remove(soFar.size() - 1);
        }
    }
}
