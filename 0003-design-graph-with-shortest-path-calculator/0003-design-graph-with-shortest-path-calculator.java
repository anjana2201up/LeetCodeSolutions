class Graph {

    private List<int[]>[] graph;

    public Graph(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        graph[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{node1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (node == node2) {
                return cost;
            }

            if (cost > dist[node]) {
                continue;
            }

            for (int[] next : graph[node]) {
                int nei = next[0];
                int newCost = cost + next[1];

                if (newCost < dist[nei]) {
                    dist[nei] = newCost;
                    pq.offer(new int[]{nei, newCost});
                }
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna