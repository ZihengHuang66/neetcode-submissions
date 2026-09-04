class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] valid = new int[target.length];
        for(int[] tri : triplets) {
            for(int i = 0; i < target.length; i++) {
                if(tri[i] > target[i]) {
                    valid[i] = 2;
                } else if(tri[i] == target[i]) {
                    valid[i] = 1;
                }
            }
        }

        int count = 0;
        for(int curr : valid) {
            if(curr == 1) count++;
        }
        return count == target.length;
    }
}
