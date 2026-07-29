class Solution {
    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DSU dsu = new DSU(n);
        boolean[] ans = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];
            int pu = dsu.find(u);
            int pv = dsu.find(v);

            if (pu == pv) {
                ans[i] = true;
                continue;
            }

            boolean ok = true;
            for (int[] r : restrictions) {
                int a = dsu.find(r[0]);
                int b = dsu.find(r[1]);
                if ((a == pu && b == pv) || (a == pv && b == pu)) {
                    ok = false;
                    break;
                }
            }

            ans[i] = ok;
            if (ok) dsu.union(pu, pv);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna