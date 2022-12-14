package _202212;

import java.util.Arrays;

public class DistanceLimitedPathsExist1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        //因为最后要根据queries返回该query的结果，同时又需要对queries按照距离从小到大排序，
        //所以需要建立映射数组进行排序，从而不用改变queries的顺序
        Integer[] index =new Integer[queries.length];
        for(int i = 0; i < queries.length; i++){
            index[i]=i;
        }
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);
        boolean[] ans = new boolean[queries.length];
        int j = 0;
        UnionFind unionFind = new UnionFind(n);
        //此时index里面值已经按照距离从小到大排序好
        for (int i :index) {
            while (j < edgeList.length && edgeList[j][2] < queries[i][2]) {
                unionFind.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            ans[i] = unionFind.find(queries[i][0]) == unionFind.find(queries[i][1]);
        }
        return ans;
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
            int parentX = find(x);
            int parentY = find(y);
            parents[parentX] = parentY;
        }
    }

    public static void main(String[] args) {
        DistanceLimitedPathsExist1697 solution = new DistanceLimitedPathsExist1697();
        solution.distanceLimitedPathsExist(5, new int[][]{{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}},
                new int[][]{{0, 4, 14}, {1, 4, 13}});
    }
}
