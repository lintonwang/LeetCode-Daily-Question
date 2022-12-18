package _202212;

import java.util.ArrayList;
import java.util.List;

public class MinMoves1703 {
    public int minMoves(int[] nums, int k) {
        //Pi=Qi-i;
        List<Integer> p = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) p.add(i - p.size());
        }
        //m equals the num of 1
        int m = p.size();
        // prefix sum of p
        int[] preSum = new int[m + 1];
        for (int i = 0; i < m; i++) {
            preSum[i + 1] = preSum[i] + p.get(i);
        }
        int ans = Integer.MAX_VALUE;
        // p[i] 到 p[i+k-1] 中所有数到 p[i+k/2] 的距离之和，取最小值
        for (int i = 0; i <= m - k; i++) {
            ans = Math.min(ans, preSum[i] + preSum[i + k] - preSum[i + k / 2] * 2 - p.get(i + k / 2) * (k % 2));
        }
        return ans;
    }
}
