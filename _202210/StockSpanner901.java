package _202210;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner901 {
    class StockSpanner {
        Deque<int[]> stack;
        int idx;

        public StockSpanner() {
            stack = new ArrayDeque<>();
            stack.push(new int[]{-1, Integer.MAX_VALUE});
            idx = 0;
        }

        public int next(int price) {
            while (price >= stack.peek()[1]) stack.pop();
            int ans = idx - stack.peek()[0];
            stack.push(new int[]{idx, price});
            idx++;
            return ans;
        }
    }
}
