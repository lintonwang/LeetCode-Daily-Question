package _202212;

import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<String>();
        int n = word.length();
        int idx = 0;
        while (true) {
            while (idx < n && !Character.isDigit(word.charAt(idx))) idx++;
            if (idx == n) break;
            int tmp = idx;
            while (tmp < n && Character.isDigit(word.charAt(tmp))) tmp++;
            while (tmp > idx && word.charAt(idx) == '0') idx++;
            set.add(word.substring(idx, tmp));
            idx = tmp;
        }
        return set.size();
    }
}
