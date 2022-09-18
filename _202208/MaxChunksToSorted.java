package _202208;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        //存储每一个块中最大值
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : arr) {
            if (stack.isEmpty() || x >= stack.peek()) {
                stack.push(x);
            } else {
                int preMax = stack.pop();
                while (!stack.isEmpty() && stack.peek() > x) stack.pop();
                stack.push(preMax);
            }
        }
        return stack.size();
    }
}
