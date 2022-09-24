package _202209;

public class Decrypt1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) return new int[n];
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        int left = k > 0 ? 1 : n + k;
        int right = k > 0 ? k : n - 1;
        int[] ans = new int[n];
        int rangeSum = 0;
        for (int i = left; i <= right; i++) {
            rangeSum += newCode[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = rangeSum;
            rangeSum -= newCode[left];
            rangeSum += newCode[right + 1];
            left++;
            right++;
        }
        return ans;
    }

}
