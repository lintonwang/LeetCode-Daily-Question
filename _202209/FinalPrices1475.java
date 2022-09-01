package _202209;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPrices1475 {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) ans[i] = prices[i];
            else ans[i] = prices[i] - prices[stack.peek()];
            stack.push(i);
        }
        return ans;
    }
}
