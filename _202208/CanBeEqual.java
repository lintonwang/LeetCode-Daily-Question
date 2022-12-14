package _202208;

public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count1 = new int[1001];
        int[] count2 = new int[1001];
        for (int num : target) count1[num]++;
        for (int num : arr) count2[num]++;
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
