package _202209;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class KSimilarity854 {

    class Pair<K, V> {
        K key;
        V val;

        Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

    }

    public int kSimilarity(String s1, String s2) {
        Set<String> seen = new HashSet<>();
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<String, Integer>(s1, 0));
        seen.add(s1);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Integer> pair = queue.poll();
                String key = pair.getKey();
                int pos = pair.getVal();
                if (key.equals(s2)) return step;
                while (pos < s1.length() && key.charAt(pos) == s2.charAt(pos)) pos++;
                for (int j = pos + 1; j < s1.length(); j++) {
                    if (key.charAt(j) == s2.charAt(j)) continue;
                    if (key.charAt(j) == s2.charAt(pos)) {
                        String swapStr = swap(key, pos, j);
                        if (!seen.contains(swapStr)) {
                            seen.add(swapStr);
                            queue.offer(new Pair<>(swapStr, pos + 1));
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    String swap(String word, int i, int j) {
        char[] chars = word.toCharArray();
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
        return new String(chars);
    }

    public static void main(String[] args) {
        KSimilarity854 kSimilarity854 = new KSimilarity854();
        kSimilarity854.kSimilarity("bccaba", "abacbc");
    }
}
