package _202210;

public class MinSwap801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int dp0 = 0, dp1 = 1;
        for (int i = 1; i < nums1.length; i++) {
            boolean flag1 = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1];
            boolean flag2 = nums2[i] > nums1[i - 1] && nums1[i] > nums2[i - 1];
            int prevDp0 = dp0, prevDp1 = dp1;
            if (flag1 && flag2) {
                dp0 = Math.min(prevDp0, prevDp1);
                dp1 = Math.min(prevDp0, prevDp1) + 1;
            } else if (flag1) {
                dp0 = prevDp0;
                dp1 = prevDp1 + 1;
            } else {
                dp0 = prevDp1;
                dp1 = prevDp0 + 1;
            }
        }
        return Math.min(dp0, dp1);
    }
}
