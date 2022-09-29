package _202208;

public class PreimageSizeFZF793 {
    public int preimageSizeFZF(int k) {
        return binarySearch(k + 1) - binarySearch(k);
    }

    int binarySearch(int k) {
        int left = 0;
        int right = 5 * k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (countTailZero(mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int countTailZero(int x) {
        int ans = 0;
        while (x != 0) {
            ans += x / 5;
            x /= 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        PreimageSizeFZF793 instance = new PreimageSizeFZF793();
        instance.preimageSizeFZF(0);
    }
}
