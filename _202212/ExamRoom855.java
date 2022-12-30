package _202212;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ExamRoom855 {
    class ExamRoom {
        TreeSet<Integer> seat;
        PriorityQueue<int[]> pq;
        int n;

        public ExamRoom(int n) {
            this.seat = new TreeSet<>();
            this.pq = new PriorityQueue<int[]>((a, b) -> {
                return (a[1] - a[0]) / 2 == (b[1] - b[0]) / 2 ? a[0] - b[0] : (b[1] - b[0] - a[1] + a[0]);
            });
            this.n = n;
        }

        public int seat() {
            if (seat.isEmpty()) {
                seat.add(0);
                return 0;
            }
            int left = seat.first(), right = n - 1 - seat.last();
            while (seat.size() >= 2) {
                int[] p = pq.peek();
                //因为可能存在未删除的区间，未删除的区间只有一侧的点是存在
                if (seat.contains(p[0]) && seat.contains(p[1]) && seat.higher(p[0]) == p[1]) {
                    int d = p[1] - p[0];
                    if (d / 2 < right || d / 2 <= left) break;
                    pq.poll();
                    pq.offer(new int[]{p[0], p[0] + d / 2});
                    pq.offer(new int[]{p[0] + d / 2, p[1]});
                    seat.add(p[0] + d / 2);
                    return p[0] + d / 2;
                }
                pq.poll();
            }
            if (right > left) {
                pq.offer(new int[]{seat.last(), n - 1});
                seat.add(n - 1);
                return n - 1;
            } else {
                pq.offer(new int[]{0, seat.first()});
                seat.add(0);
                return 0;
            }
        }

        public void leave(int p) {
            //如果属于中间的区间席位，只是添加了两侧两个点组成的新区间，还需要删除
            //[左侧点，当前点],[当前点，右侧点]两个区间
            if (p != seat.first() && p != seat.last()) {
                int prev = seat.lower(p);
                int next = seat.higher(p);
                pq.offer(new int[]{prev, next});
            }
            seat.remove(p);
        }
    }
}
