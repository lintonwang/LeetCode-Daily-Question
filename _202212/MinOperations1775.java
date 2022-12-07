package _202212;

import java.util.Arrays;

public class MinOperations1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (6 * m < n || 6 * n < m) return -1;
        int[] count1 = new int[7];
        int[] count2 = new int[7];
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 == sum2) return 0;
        for (int num : nums1) {
            count1[num]++;
        }
        for (int num : nums2) {
            count2[num]++;
        }
        if (sum1 > sum2) return minOperations(sum1 - sum2, count1, count2);
        return minOperations(sum2 - sum1, count2, count1);
    }

    int minOperations(int diff, int[] count1, int[] count2) {
        int res = 0;
        int[] all = new int[7];
        for (int i = 1; i < 7; i++) {
            all[i - 1] += count1[i];
            all[6 - i] += count2[i];
        }
        for (int i = 5; i >= 1 && diff > 0; i--) {
            //if diff==11,then need 3*5
            int round = Math.min((diff - 1 )/ i + 1, all[i]);
            res += round;
            diff -= round * i;
        }
        return res;
    }
}
