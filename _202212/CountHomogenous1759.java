package _202212;

public class CountHomogenous1759 {
    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        long sum = 0;
        int n = s.length();
        char pre = s.charAt(0);
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == pre) {
                count++;
            } else {
                sum += (long) (count + 1) * count / 2;
                count = 1;
                pre = c;
            }
        }
        sum += (long) (count + 1) * count / 2;
        return (int) (sum % MOD);
    }
}
