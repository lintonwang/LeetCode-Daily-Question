package _202209;

public class MaximumSwap670 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int maxIdx = n - 1;
        int preIdx = -1;
        int maxStash = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] > chars[maxIdx]) {
                maxIdx = i;
            } else if (chars[i] < chars[maxIdx]) {
                //保存替换的位置对
                preIdx = i;
                maxStash = maxIdx;
            }
        }
        if (preIdx >= 0) {
            swap(chars, preIdx, maxStash);
            return Integer.parseInt(new String(chars));
        }
        return num;
    }

    void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        MaximumSwap670 maximumSwap670 = new MaximumSwap670();
//        maximumSwap670.maximumSwap(10);
        maximumSwap670.maximumSwap(98368);
    }
}
