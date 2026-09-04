class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] notvalid = new boolean[triplets.length];
        for(int i = 0; i < triplets.length; i++) {
            int[] curr = triplets[i];
            for(int j = 0; j < triplets[0].length; j++) {
                if(curr[j] > target[j]) {
                    notvalid[i] = true;
                }
            }
        }

        boolean[] validMap = new boolean[target.length];
        for(int i = 0; i < triplets.length; i++) {
            if(notvalid[i]) continue;
            int[] curr = triplets[i];
            for(int j = 0; j < target.length; j++) {
                if(curr[j] == target[j]) {
                    validMap[j] = true;
                }
            }
        }
        for(boolean bool : validMap) {
            if(!bool) return false;
        }
        return true;
    }
}
