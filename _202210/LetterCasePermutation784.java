package _202210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String s) {
        Queue<StringBuffer> queue = new ArrayDeque<>();
        queue.offer(new StringBuffer());
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            StringBuffer sb = queue.peek();
            if (sb.length() == s.length()) {
                ans.add(sb.toString());
                queue.poll();
            } else {
                int pos = sb.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuffer next = new StringBuffer(sb);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                sb.append(s.charAt(pos));
            }
        }
        return ans;
    }
}
