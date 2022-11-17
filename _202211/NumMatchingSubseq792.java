package _202211;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumMatchingSubseq792 {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] queue = new ArrayDeque[26];
        int n = words.length;
        for (int i = 0; i < 26; i++) {
            queue[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < n; i++) {
            queue[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int size = queue[c - 'a'].size();
            while (size > 0) {
                int[] pair = queue[c - 'a'].poll();
                int wordIdx = pair[1];
                String word = words[pair[0]];
                if (wordIdx == word.length() - 1) ans++;
                else {
                    pair[1] += 1;
                    queue[word.charAt(pair[1]) - 'a'].offer(pair);
                }
                size--;
            }
        }
        return ans;
    }
}
