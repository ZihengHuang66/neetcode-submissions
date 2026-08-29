class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(
            Math.pow(b[0], 2) + Math.pow(b[1], 2), Math.pow(a[0], 2) + Math.pow(a[1], 2)
        ));

        for(int[] point : points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while(!maxHeap.isEmpty()) {
            result[index] = maxHeap.poll();
            index++;
        }
        return result;
    }

}
