package _202210;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, right = 0;
        int ans = Integer.MIN_VALUE;
        while (right < fruits.length) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);
            right++;
            while (count.size() > 2) {
                count.put(fruits[left], count.get(fruits[left]) - 1);
                if (count.get(fruits[left]) == 0) count.remove(fruits[left]);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
