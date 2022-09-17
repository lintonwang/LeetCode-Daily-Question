package _202209;

import java.util.Arrays;

public class MaxLengthBetweenEqualCharacters1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] chars = new int[26];
        Arrays.fill(chars, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c - 'a'] < 0) chars[c - 'a'] = i;
            else {
                ans = Math.max(ans, i - chars[c - 'a'] - 1);
            }
        }
        return ans;
    }
}
