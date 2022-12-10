package _202212;

import java.util.Arrays;
import java.util.Comparator;

public class MaxHeight1691 {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, Comparator.comparingInt(a -> (a[0] + a[1] + a[2])));
        int n = cuboids.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] &&
                        cuboids[j][2] <= cuboids[i][2])
                    //先从小的开始放，再开始放大的，所以是加上大的i的最大高度而不是j的
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
