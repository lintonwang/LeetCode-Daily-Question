package _202212;

public class GetLucky1945 {
    public int getLucky(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) sb.append(s.charAt(i) - 'a' + 1);
        String sum = sb.toString();
        for (int i = 0; i < k; i++) {
            sum = bitSum(sum);
        }
        return Integer.parseInt(sum);
    }

    String bitSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        GetLucky1945 solution = new GetLucky1945();
        solution.getLucky("iiii",1);
    }
}
