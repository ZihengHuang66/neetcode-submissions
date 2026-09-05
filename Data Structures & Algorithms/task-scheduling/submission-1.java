class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt : count) {
            if(cnt > 0) {
                maxHeap.offer(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>(); 
        //[remaining count after running, next available time]
        
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int curr = maxHeap.poll();
                if(curr - 1 > 0) {
                    q.offer(new int[]{curr - 1, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
