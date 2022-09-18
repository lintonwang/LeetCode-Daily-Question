package _202209;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestIsland827 {

    public final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] tag = new int[m][n];
        Map<Integer, Integer> areas = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * m + j + 1;
                if (tag[i][j] == 0 && grid[i][j] == 1) {
                    int area = dfs(grid, i, j, tag, idx);
                    areas.put(idx, area);
                    ans = Math.max(ans, area);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> used = new HashSet<>();
                    for (int k = 0; k < directions.length; k++) {
                        int nextX = i + directions[k][0];
                        int nextY = j + directions[k][1];
                        if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && grid[nextX][nextY] == 1 && !used.contains(tag[nextX][nextY])) {
                            used.add(tag[nextX][nextY]);
                            area += areas.get(tag[nextX][nextY]);
                        }
                    }
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }


    int dfs(int[][] grid, int x, int y, int[][] tag, int idx) {
        int m = grid.length, n = grid[0].length;
        tag[x][y] = idx;
        int area = 1;
        for (int i = 0; i < directions.length; i++) {
            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && grid[nextX][nextY] == 1 && tag[nextX][nextY] == 0) {
                area += dfs(grid, nextX, nextY, tag, idx);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        LargestIsland827 largestIsland827 = new LargestIsland827();
        largestIsland827.largestIsland(new int[][]{{1, 1}, {1, 0}});
    }
}
