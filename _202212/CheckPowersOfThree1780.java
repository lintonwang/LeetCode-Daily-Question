package _202212;

public class CheckPowersOfThree1780 {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            int tmp = n % 3;
            if (tmp == 2) return false;
            n /= 3;
        }
        return true;
    }
}
