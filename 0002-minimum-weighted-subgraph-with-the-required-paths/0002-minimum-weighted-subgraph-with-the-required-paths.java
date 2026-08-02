class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<int[]>[] graph = new ArrayList[n];
        List<int[]>[] reverse = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            reverse[e[1]].add(new int[]{e[0], e[2]});
        }

        long[] d1 = dijkstra(graph, src1, n);
        long[] d2 = dijkstra(graph, src2, n);
        long[] d3 = dijkstra(reverse, dest, n);

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (d1[i] == Long.MAX_VALUE || d2[i] == Long.MAX_VALUE || d3[i] == Long.MAX_VALUE)
                continue;
            ans = Math.min(ans, d1[i] + d2[i] + d3[i]);
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    private long[] dijkstra(List<int[]>[] graph, int src, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{src, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            for (int[] next : graph[node]) {
                int nei = next[0];
                long nd = d + next[1];

                if (nd < dist[nei]) {
                    dist[nei] = nd;
                    pq.offer(new long[]{nei, nd});
                }
            }
        }

        return dist;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna