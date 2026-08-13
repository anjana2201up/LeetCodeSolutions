class Solution {
    static class Node {
        int len;
        int pref;
        int suff;
        int best;
        char left;
        char right;

        Node() {}

        Node(char c) {
            len = 1;
            pref = 1;
            suff = 1;
            best = 1;
            left = c;
            right = c;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int idx = queryIndices[i];
            arr[idx] = queryCharacters.charAt(i);

            update(1, 0, n - 1, idx, arr[idx]);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            tree[node] = new Node(c);
            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, c);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, c);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {
        Node res = new Node();

        res.len = a.len + b.len;
        res.left = a.left;
        res.right = b.right;

        res.pref = a.pref;
        if (a.pref == a.len && a.right == b.left) {
            res.pref = a.len + b.pref;
        }

        res.suff = b.suff;
        if (b.suff == b.len && a.right == b.left) {
            res.suff = b.len + a.suff;
        }

        res.best = Math.max(a.best, b.best);

        if (a.right == b.left) {
            res.best = Math.max(res.best, a.suff + b.pref);
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna