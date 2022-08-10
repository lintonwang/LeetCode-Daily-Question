import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolveEquation {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Integer> param = new ArrayDeque<>();
        calculate(strs[0], num, param, 1);
        calculate(strs[1], num, param, -1);
        int sum = num.stream().reduce(0, (a, b) -> a + b);
        int sumParam = param.stream().reduce(0, (a, b) -> a + b);
        if (sumParam == 0 && sum == 0) return "Infinite solutions";
        if (sumParam == 0) return "No solution";
        return "x=" + -1 * sum / sumParam;
    }

    void calculate(String str, Deque<Integer> num, Deque<Integer> param, int globalSign) {
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                sign = 1;
            } else if (str.charAt(i) == '-') {
                sign = -1;
            } else {
                if (str.charAt(i) == 'x') {
                    param.offer(globalSign * sign);
                } else {
                    int x = 0;
                    while (i < str.length() && Character.isDigit(str.charAt(i))) {
                        x = x * 10 + str.charAt(i) - '0';
                        i++;
                    }
                    if (i < str.length() && str.charAt(i) == 'x') {
                        param.offer(globalSign * sign * x);
                    } else {
                        i--;
                        num.offer(globalSign * sign * x);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        solveEquation.solveEquation("x=x+2");
    }
}
