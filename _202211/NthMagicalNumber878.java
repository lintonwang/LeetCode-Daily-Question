package _202211;

public class NthMagicalNumber878 {
    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long left = Math.min(a, b);
        long right = left * n;
        int c = lcm(a, b);
        while (left < right) {
            //if left = mid,mid must = (left+right+1)/2;
            long mid = (left + right) / 2;
            long val = mid / a + mid / b - mid / c;
            if (val >= n) {
                right = mid;
            } else left = mid + 1;
        }
        return (int) ((left) % MOD);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        NthMagicalNumber878 solution = new NthMagicalNumber878();
        solution.nthMagicalNumber(4, 2, 3);
    }

}
