class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size() > 1) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();
            if(max1 > max2) {
                maxHeap.offer(max1 - max2);
            }
        }
        if(maxHeap.isEmpty()) {
            return 0;
        } 
        return maxHeap.peek();
    }

}
