import java.util.*;

class Solution {
    int ans;
    int[] values;
    List<int[]>[] graph;
    int[] vis;
    int maxTime;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        this.values = values;
        this.maxTime = maxTime;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        vis = new int[n];
        dfs(0, 0, values[0]);
        return ans;
    }

    private void dfs(int node, int time, int score) {
        if (node == 0) ans = Math.max(ans, score);
        vis[node]++;
        for (int[] next : graph[node]) {
            int v = next[0], t = next[1];
            if (time + t > maxTime) continue;
            if (vis[v] == 0) {
                dfs(v, time + t, score + values[v]);
            } else {
                dfs(v, time + t, score);
            }
        }
        vis[node]--;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna