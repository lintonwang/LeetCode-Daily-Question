package _202211;

public class MinOperations1758 {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == (i % 2) + '0') {
                count++;
            }
        }
        return Math.min(count, n - count);
    }
}
