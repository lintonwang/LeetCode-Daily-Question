package _202211;

import java.util.*;

public class ReachableNodes882 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] adjacent = new List[n];
        for (int i = 0; i < n; i++) adjacent[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], count = edge[2];
            adjacent[u].add(new int[]{v, count});
            adjacent[v].add(new int[]{u, count});
        }
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        while (!pq.isEmpty() && pq.peek()[0] <= maxMoves) {
            int[] pair = pq.poll();
            int step = pair[0], u = pair[1];
            if (!visited.add(u)) continue;
            ans++;
            for (int[] next : adjacent[u]) {
                int v = next[0], count = next[1];
                if (count + step + 1 <= maxMoves && !visited.contains(v)) {
                    pq.offer(new int[]{count + step + 1, v});
                }
                indexMap.put(uvToIndex(u, v, n), Math.min(count, maxMoves - step));
            }
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], count = edge[2];
            ans += Math.min(count, indexMap.getOrDefault(uvToIndex(u, v, n), 0) +
                    indexMap.getOrDefault(uvToIndex(v, u, n), 0));
        }
        return ans;
    }

    int uvToIndex(int u, int v, int count) {
        return u * count + v;
    }
}
