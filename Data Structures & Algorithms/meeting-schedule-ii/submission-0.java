/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int max = 0;
        while(p1 < intervals.size()) {
            if(start[p1] < end[p2]) {
                count++;
                p1++;
            } else {
                count--;
                p2++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
