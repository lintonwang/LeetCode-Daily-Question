package _202212;

import java.util.Arrays;

public class DistanceLimitedPathsExist1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        boolean[] ans = new boolean[queries.length];
        for(int )
    }

    class UnionFind {
        int[] parents;

        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int x) {
            if (parents[x] == x)
                return x;
            return find(parents[x]);
        }

        void union(int x, int y) {
            if (find(x) != find(y)) {
                parents[x] = y;
            }
        }
    }
}
