package _202212;

public class MinimumBoxes1739 {
    public int minimumBoxes(int n) {
        int i = (int) Math.pow(6.0 * n, 1.0 / 3);
        if (g(i) < n) i++;
        n -= g(i - 1);
        int j = (int) Math.ceil(1.0 * (Math.sqrt((long) 8 * n + 1) - 1) / 2);
        return (i - 1) * i / 2 + j;
    }

    long g(int i) {
        return (long) i * (i + 1) * (i + 2) / 6;
    }
}
