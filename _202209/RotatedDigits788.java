package _202209;

public class RotatedDigits788 {
    //对应数字0~9旋转180°后是否符合条件，-1-旋转后为无效数字，0-旋转后不变 1-旋转后为另一有效数字
    public int rotatedDigits(int n) {
        int[] flags = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            boolean flag = true;
            boolean change = false;
            for (int j = 0; j < num.length(); j++) {
                if (flags[num.charAt(j) - '0'] == -1) {
                    flag = false;
                    break;
                } else if (flags[num.charAt(j) - '0'] == 1)
                    change = true;
            }
            if (flag && change) ans++;
        }
        return ans;
    }
}
