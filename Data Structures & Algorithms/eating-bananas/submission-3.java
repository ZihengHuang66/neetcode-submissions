class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upper = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > upper) {
                upper = piles[i];
            }
        }

        int minSpeed = upper;
        int left = 1;
        int right = upper;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for(int i = 0; i < piles.length; i++) {
                if(piles[i] % mid != 0) {
                    time = time + piles[i] / mid + 1;
                } else {
                    time = time + piles[i] / mid;
                }
            }

            if(time <= h) {
                if(mid < minSpeed) {
                    minSpeed = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }
}
// 1 2 3 4
// 4 10 23 25