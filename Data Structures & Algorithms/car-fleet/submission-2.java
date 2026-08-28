class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        
        double[] time = new double[position.length];
        for(int i = 0; i < time.length; i++) {
            time[i] = (double) (target - pair[i][0]) / pair[i][1];
        }

        Stack<Double> currFleet = new Stack<>();
        for(int i = 0; i < time.length; i++) {
            if(!currFleet.isEmpty() && time[i] <= currFleet.peek()) {
                continue;
            } 
            currFleet.push(time[i]);
        }
        
        return currFleet.size();
    }
}
