package _202210;

public class ArraySign1822 {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num < 0) sign *= -1;
            else if (num == 0) return 0;
        }
        return sign;
    }
}
