class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, result, 0, new ArrayList<>());
        return result;
    }
    private void subsets(int[] nums, List<List<Integer>> result, int index, List<Integer> soFar) {
        if(index == nums.length) {
            result.add(new ArrayList<>(soFar)); // create a copy of soFar!!!
        } else {
            subsets(nums, result, index + 1, soFar);
            soFar.add(nums[index]);
            subsets(nums, result, index + 1, soFar);
            soFar.remove(soFar.size() - 1);
        }
    }
}
