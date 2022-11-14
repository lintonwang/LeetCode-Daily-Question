package _202211;

public class ReachNumber754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int i = 1; ; i++) {
            sum += i;
            if (sum >= target) {
                int d = sum - target;
                if (d % 2 == 0) {
                    return i;
                }
                return (sum + i + 1 - target) % 2 == 0 ? i + 1 : i + 2;
            }
        }
    }
}
