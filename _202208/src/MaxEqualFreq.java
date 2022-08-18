import java.util.HashMap;
import java.util.Map;

public class MaxEqualFreq {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (count.getOrDefault(num, 0) == 0) freq.put(1, freq.getOrDefault(1, 0) + 1);
            else {
                freq.put(count.get(num), freq.get(count.get(num)) - 1);
                freq.put(count.get(num) + 1, freq.getOrDefault(count.get(num) + 1, 0) + 1);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(num));
            if (maxFreq == 1 || maxFreq * freq.get(maxFreq) == i || (maxFreq - 1) * (freq.get(maxFreq - 1) + 1) == i)
                ans = i + 1;
        }
        return ans;
    }
}
