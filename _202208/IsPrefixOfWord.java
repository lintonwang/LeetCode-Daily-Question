package _202208;

public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        int idx = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].startsWith(searchWord)) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
