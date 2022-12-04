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
