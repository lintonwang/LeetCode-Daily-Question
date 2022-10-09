package _202210;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else {
                int tmp = stack.pop();
                stack.push(stack.pop() + Math.max(tmp * 2, 1));
            }
        }
        return stack.peek();
    }
}
