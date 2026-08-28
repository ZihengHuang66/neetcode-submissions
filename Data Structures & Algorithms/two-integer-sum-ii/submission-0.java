class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(numbers[left] + numbers[right] != target) {
            if(numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        int[] result = new int[2];
        result[0] = left + 1;
        result[1] = right + 1;

        return result;
    }
}
// 1 2 3 4 target = 6