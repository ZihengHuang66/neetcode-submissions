class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> numsFreq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(numsFreq.containsKey(nums[i])) {
                numsFreq.put(nums[i], numsFreq.get(nums[i]) + 1);
            } else {
                numsFreq.put(nums[i], 1);
            }
        }
        for(int i = 0; i < k; i++) {
            int maxNum = 0;
            int maxAppear = 0;
            for(int num : numsFreq.keySet()) {
                if(numsFreq.get(num) > maxAppear) {
                    maxAppear = numsFreq.get(num);
                    maxNum = num;
                }
            }
            result[i] = maxNum;
            numsFreq.remove(maxNum);
        }
            
        return result;
    }
}
