import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        vis[source] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == destination) return true;
            for (int v : graph[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.offer(v);
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna