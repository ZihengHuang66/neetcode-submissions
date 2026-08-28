class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> sorted = new TreeSet<>();

        for(int i = 0; i < nums.length; i++) {
            sorted.add(nums[i]);
        }

        List<Integer> currList = new ArrayList<>();
        int maxLength = 0;

        for(int curr : sorted) {
            if(currList.isEmpty() || curr - 1 == currList.get(currList.size() - 1)) {
                currList.add(curr);
                if(currList.size() > maxLength) {
                    maxLength = currList.size();
                }
            } else { 
                currList = new ArrayList<>();
                currList.add(curr);
            }
        }

        return maxLength;
    }
    // -1 0 1 3 4 5 6 7 8 9
}
