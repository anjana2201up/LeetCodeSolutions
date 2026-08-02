class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> large = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }

                if (i != n / i) {
                    large.add(n / i);
                }
            }
        }

        if (k <= large.size()) {
            return large.get(large.size() - k);
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna