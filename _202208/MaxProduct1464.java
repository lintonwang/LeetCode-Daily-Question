package _202208;

public class MaxProduct1464 {
    public int maxProduct(int[] nums) {
        int max1 = 1, max2 = 1;
        int min1 = 1, min2 = 1;
        for (int num : nums) {
            if (num > 1) {
                if (num >= max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) max2 = num;
            } else if (num < 1) {
                if (num <= min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) min2 = num;
            }
        }
        return Math.max((min1 - 1) * (min2 - 1), (max1 - 1) * (max2 - 1));
    }
}
