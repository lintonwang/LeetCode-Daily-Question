package _202211;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FreqStack895 {
    class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Deque<Integer>> index;
        int maxFreq;

        public FreqStack() {
            freq = new HashMap<Integer, Integer>();
            index = new HashMap<Integer, Deque<Integer>>();
            maxFreq = 0;
        }

        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            index.putIfAbsent(freq.get(val), new ArrayDeque<>());
            index.get(freq.get(val)).push(val);
            maxFreq = Math.max(maxFreq, freq.get(val));
        }

        public int pop() {
            int val = index.get(maxFreq).peek();
            freq.put(val, freq.get(val) - 1);
            index.get(maxFreq).pop();
            if (index.get(maxFreq).isEmpty()) maxFreq--;
            return val;
        }
    }
}
