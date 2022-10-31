package _202210;

public class MagicalString481 {
    public int magicalString(int n) {
        if (n < 4) return 1;
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int count = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = s[i] - '0';
            int num = s[j - 1]-'0' == 1 ? 2 : 1;
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) count++;
                j++;
                size--;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        MagicalString481 magicalString481 = new MagicalString481();
        magicalString481.magicalString(6);
    }
}
