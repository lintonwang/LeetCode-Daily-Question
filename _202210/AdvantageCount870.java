package _202210;

import java.util.Arrays;

public class AdvantageCount870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] array1 = new Integer[n];
        Integer[] array2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            array1[i] = i;
            array2[i] = i;
        }
        Arrays.sort(array1, (a, b) -> nums1[a] - nums1[b]);
        Arrays.sort(array2, (a, b) -> nums2[a] - nums2[b]);
        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[array1[i]] > nums2[array2[left]]) {
                ans[array2[left]] = nums1[array1[i]];
                left++;
            } else {
                ans[array2[right]] = nums1[array1[i]];
                right--;
            }
        }
        return ans;
    }
}
