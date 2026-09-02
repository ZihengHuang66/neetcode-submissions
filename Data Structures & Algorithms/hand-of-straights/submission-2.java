class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < hand.length; i++) {
            int curr = hand[i];
            if(!map.containsKey(curr)) {
                map.put(curr, 0);
            } 
            map.put(curr, map.get(curr) + 1);
        }

        for(int i = 0; i < hand.length; i++) {
            int curr = hand[i];
            if(map.get(curr) == 0) {
                continue;
            }
            for(int j = curr; j < curr + groupSize; j++) {
                if(!map.containsKey(j) || map.get(j) == 0) {
                    return false;
                } 
                map.put(j, map.get(j) - 1);
            }
        }
        return true;
    }
}
