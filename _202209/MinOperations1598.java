package _202209;

public class MinOperations1598 {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) depth--;
            } else if (log.equals("./")) {
            } else depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MinOperations1598 minOperations1598 = new MinOperations1598();
        minOperations1598.minOperations(new String[]{"./", "../", "./"});
    }
}
