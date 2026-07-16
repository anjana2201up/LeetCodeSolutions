class Solution {

    public int minReorder(int n, int[][] connections) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : connections) {

            int from = edge[0];
            int to = edge[1];

            graph[from].add(new int[]{to, 1}); // original direction
            graph[to].add(new int[]{from, 0}); // reverse direction
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    private int dfs(int city, List<int[]>[] graph, boolean[] visited) {

        visited[city] = true;

        int changes = 0;

        for (int[] next : graph[city]) {

            int neighbor = next[0];
            int cost = next[1];

            if (!visited[neighbor]) {
                changes += cost;
                changes += dfs(neighbor, graph, visited);
            }
        }

        return changes;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna