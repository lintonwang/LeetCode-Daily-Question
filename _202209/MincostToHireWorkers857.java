package _202209;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MincostToHireWorkers857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] employee = new Integer[n];
        for (int i = 0; i < n; i++) {
            employee[i] = i;
        }
        //整个工作组的总工作质量为：totalq，总的支付金额为 totalc。那么按照题目的要求对于任意工人 hi
        //totalc*quality[hi]/totalq>=wage[hi]
        //即 totalc>=totalq*wage[hi]/quality[hi]
        //使得worker按照性价比从高到低排序.
        Arrays.sort(employee, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return wage[o1] * quality[o2] - wage[o2] * quality[o1];
            }
        });
        double sumWage = 1e9;
        double sumQuality = 0d;
        //将已经加入工作组的worker按照工作量从大到小排列
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            sumQuality += quality[employee[i]];
            pq.offer(quality[employee[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            //不断尝试将低性价比的worker加入工作组
            sumQuality += quality[employee[i]];
            pq.offer(quality[employee[i]]);
            double sum = sumQuality * wage[employee[i]] / quality[employee[i]];
            sumWage = Math.min(sum, sumWage);
            sumQuality -= pq.poll();
        }
        return sumWage;
    }

    public static void main(String[] args) {
        MincostToHireWorkers857 mincostToHireWorkers857 = new MincostToHireWorkers857();
        mincostToHireWorkers857.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2);
    }


}
