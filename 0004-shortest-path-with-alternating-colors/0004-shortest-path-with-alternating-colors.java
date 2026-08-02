class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : redEdges) {
            graph[edge[0]].add(new int[]{edge[1], 0});
        }

        for (int[] edge : blueEdges) {
            graph[edge[0]].add(new int[]{edge[1], 1});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, -1});
        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];

                if (ans[node] == -1) {
                    ans[node] = dist;
                }

                for (int[] next : graph[node]) {
                    int nei = next[0];
                    int nextColor = next[1];

                    if (nextColor != color && !visited[nei][nextColor]) {
                        visited[nei][nextColor] = true;
                        queue.offer(new int[]{nei, nextColor});
                    }
                }
            }

            dist++;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna