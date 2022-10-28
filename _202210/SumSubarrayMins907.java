package _202210;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumSubarrayMins907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) stack.pop();
            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) stack.pop();
            right[i] = (stack.isEmpty() ? arr.length : stack.peek()) - i;
            stack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }
}
