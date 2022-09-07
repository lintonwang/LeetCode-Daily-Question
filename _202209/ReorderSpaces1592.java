package _202209;

public class ReorderSpaces1592 {
    public String reorderSpaces(String text) {
        int len = text.length();

        // 正则匹配\s匹配任意空字符，制表符、换页符  \在java里是转义字符，所以需要\\
        String[] words = text.trim().split("\\s+");

        int blankCnt = len;
        for (String word : words) blankCnt -= word.length();
        StringBuffer sb = new StringBuffer();
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < blankCnt; i++) sb.append(" ");
            return sb.toString();
        }
        int average = blankCnt / (words.length - 1);
        int tail = blankCnt % (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1)
                for (int j = 0; j < average; j++) sb.append(" ");
        }
        for (int i = 0; i < tail; i++) sb.append(" ");
        return sb.toString();
    }
}
