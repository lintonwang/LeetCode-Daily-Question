package _202211;

import java.util.HashMap;
import java.util.Map;

public class SplitArraySameAverage805 {
    public boolean splitArraySameAverage(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }
        int n1 = n >> 1, n2 = n - n1, max1 = 1 << n1, max2 = 1 << n2;
        Map<Integer, Integer> map = new HashMap<>();
        //首先把所有的第一个集合的可能的和收集起来：
        for (int i = 0; i < max1; i++) {
            int a = find(i, nums, 0);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        //之后验证第二个集合，先不要验证全部不拿或者全部都拿的情况
        for (int i = 1; i < max2 - 1; i++) {
            int a = find(i, nums, n1);
            if (a == 0 || map.containsKey(-a)) {
                return true;
            }
        }
        //全不拿（0）的情况已经在上边得到了验证，剩下的只需要验证全都拿的情况：
        int a1 = find(max1 - 1, nums, 0), a2 = find(max2 - 1, nums, n1);
        return a1 + a2 != 0 && map.containsKey(-a2) || a1 + a2 == 0 && map.get(-a2) > 1;
    }

    int find(int mask, int[] nums, int start) {
        int ans = 0;
        for (int i = 0; mask > 0; i++, mask >>= 1) {
            if ((mask & 1) == 1) {
                ans += nums[start + i];
            }
        }
        return ans;
    }
}
