package _202208;

public class Shuffle1470 {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int j = i;
                while (nums[i] > 0) {
                    j = j < n ? j * 2 : 2 * (j - n) + 1;
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = -tmp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = -nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        Shuffle1470 so = new Shuffle1470();
        so.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
    }
}
