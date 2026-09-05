class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }

        // Always process the max freq item to save time
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt : count) {
            if(cnt > 0) {
                maxHeap.offer(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>(); 
        /* cool down queue, if the curr reaches time, put it back to maxheap
        represent as [remaining count after running, next available time] */
        
        /* process the maxHeap and add it to queue, then check if the item at 
           the front of queue is now available */
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = q.peek()[1];
                /** if we don't have any available task to do, use idles!
                by jumping to the next available time directly **/
            } else {
                // if it is available, push the updated freq back to maxHeap for next use
                int curr = maxHeap.poll();
                /* if the task is finished at the time, ignore it as completed
                   do not push it back to queue */
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
