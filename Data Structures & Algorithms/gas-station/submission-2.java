class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int curr = 0;
        int res = 0;

        for(int i = 0; i < gas.length; i++) {
            curr = curr + gas[i] - cost[i];
            if(curr < 0) {
                res = i + 1;
                curr = 0;
            }
            tank = tank + gas[i] - cost[i];
        }
        if(tank < 0) {
            return -1;
        }
        return res;
    }
}
