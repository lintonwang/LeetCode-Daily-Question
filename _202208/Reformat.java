package _202208;

public class Reformat {
    public String reformat(String s) {
        int digit = 0;
        int chars = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) digit++;
            else chars++;
        }
        if (Math.abs(digit - chars) > 1) return "";
        int i = 0, j = 1;
        boolean flag = digit >= chars ? true : false;
        char[] charArray = s.toCharArray();
        while (i < s.length() ) {
            if (Character.isDigit(charArray[i]) == flag){
                i += 2;
                continue;
            }
            while (j < s.length() && Character.isDigit(charArray[j]) != flag) j += 2;
            swap(charArray, i, j);

        }
        return new String(charArray);
    }

    void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        Reformat reformat = new Reformat();
        reformat.reformat("covid2019");
    }
}
