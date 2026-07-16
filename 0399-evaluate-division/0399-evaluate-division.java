class Solution {

    class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        Map<String, List<Pair>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, values[i]));
            graph.get(v).add(new Pair(u, 1.0 / values[i]));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else {

                Set<String> visited = new HashSet<>();

                ans[i] = dfs(src, dest, 1.0, graph, visited);
            }
        }

        return ans;
    }

    private double dfs(String curr,
                       String target,
                       double product,
                       Map<String, List<Pair>> graph,
                       Set<String> visited) {

        if (curr.equals(target))
            return product;

        visited.add(curr);

        for (Pair next : graph.get(curr)) {

            if (!visited.contains(next.node)) {

                double res = dfs(next.node,
                                 target,
                                 product * next.weight,
                                 graph,
                                 visited);

                if (res != -1.0)
                    return res;
            }
        }

        return -1.0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna