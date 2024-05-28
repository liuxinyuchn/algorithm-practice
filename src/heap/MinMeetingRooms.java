package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// lc 253.会议室Ⅱ
public class MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ans = 0;
        for (int[] interval : intervals) {
            while (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.poll();
            }
            heap.offer(interval[1]);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }
}
