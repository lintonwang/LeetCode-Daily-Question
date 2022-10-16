package _202210;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] dis = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = new ArrayList<>();
        }
        int[] colors = new int[n + 1];
        for (int[] dislike : dislikes) {
            dis[dislike[0]].add(dislike[1]);
            dis[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0 && !dfs(i, 1, dis, colors)) return false;
        }
        return true;
    }

    boolean dfs(int curr, int color, List<Integer>[] dis, int[] colors) {
        colors[curr] = color;
        for (int dislike : dis[curr]) {
            if (colors[dislike] != 0 && colors[curr] == colors[dislike]) return false;
            //当前color为1时，3^1=2，当color为2时，3^2=1,即选定下一个color必定与当前相反
            if (colors[dislike] == 0 &&!dfs(dislike, 3 ^ color, dis, colors)) return false;
        }
        return true;
    }
}
