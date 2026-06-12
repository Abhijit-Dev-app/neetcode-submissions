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
//  [(0, 40), (5, 10), (15, 20)]

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0){
            return 0;
        }
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        // int count  = 1;
        for(int iterator = 1; iterator < intervals.size();iterator++){
            int top = pq.peek();
            pq.add(intervals.get(iterator).end);
            if(intervals.get(iterator).start >= top){
                pq.poll();
            }
        }
        return pq.size();
    }
}
