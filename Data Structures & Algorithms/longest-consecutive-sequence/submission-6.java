class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> sorted = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            sorted.add(nums[i]);
        }
        
        int maxLength = 0;
        for(int curr : sorted) {
            if(!sorted.contains(curr - 1)) {
                int currLength = 1;
                while(sorted.contains(curr + 1)) {
                    currLength++;
                    curr++;
                }
                if(currLength > maxLength) {
                    maxLength = currLength;
                }
            } 
        }
        return maxLength;
    }
}
// 2 20 4 10 3 5