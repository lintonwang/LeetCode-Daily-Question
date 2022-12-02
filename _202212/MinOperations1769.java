package _202212;

public class MinOperations1769 {
    public int[] minOperations(String boxes) {
        int left = boxes.charAt(0) - '0', right = 0, operation = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                operation += i;
                right++;
            }
        }
        int n = boxes.length();
        int[] result = new int[n];
        result[0] = operation;
        for (int i = 1; i < n; i++) {
            operation += left - right;
            result[i] = operation;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
        }
        return result;
    }
}
