package _202212;

import java.util.Arrays;

public class ClosestCost1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int least = Arrays.stream(baseCosts).min().getAsInt();
        if (least >= target) return least;
        boolean[] dp = new boolean[target + 1];
        int res = target + (target - least);
        for (int base : baseCosts) {
            if (base <= target) dp[base] = true;
                //if all of baseCosts is more than target,res must return min cost
            else res = Math.min(res, base);
        }
        for (int top : toppingCosts) {
            for (int i = 0; i < 2; i++) {
                //如果递增的话，在一轮循环里，可能会多次使用配料。比如循环之前dp[10]=true,
                // 现在配料2元，你在处理10的时候会把dp[12]变成true，
                // 然后在处理dp[12]的时候又会把dp[14]变成true。如果倒过来就不会有这样的问题。
                for (int j = target; j > 0; j--) {
                    if (dp[j] && j + top > target) res = Math.min(res, j + top);
                    if (j - top > 0) dp[j] = dp[j] | dp[j - top];
                }
            }
        }
        //res - target:目前获得与target的差距
        for (int i = 0; i <= res - target; i++) {
            if (dp[target - i]) return target - i;
        }
        return res;
    }
}
