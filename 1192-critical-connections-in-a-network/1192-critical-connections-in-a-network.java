import java.util.*;

class Solution {
    List<List<Integer>> graph;
    List<List<Integer>> ans;
    int[] disc;
    int[] low;
    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList<>();
        ans = new ArrayList<>();
        disc = new int[n];
        low = new int[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Arrays.fill(disc, -1);

        dfs(0, -1);

        return ans;
    }

    public void dfs(int node, int parent) {
        disc[node] = low[node] = time++;

        for(int next : graph.get(node)) {
            if(next == parent)
                continue;

            if(disc[next] == -1) {
                dfs(next, node);
                low[node] = Math.min(low[node], low[next]);

                if(low[next] > disc[node]) {
                    ans.add(Arrays.asList(node, next));
                }
            } else {
                low[node] = Math.min(low[node], disc[next]);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna