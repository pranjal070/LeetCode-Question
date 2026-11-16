
import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1000000007;
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) ->
                Long.compare(a[0], b[0]));

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : adj.get(u)) {

                int v = edge[0];
                int time = edge[1];

                long newDist = d + time;

                if (newDist < dist[v]) {

                    dist[v] = newDist;
                    ways[v] = ways[u];

                    pq.add(new long[]{newDist, v});
                }
                else if (newDist == dist[v]) {

                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}
