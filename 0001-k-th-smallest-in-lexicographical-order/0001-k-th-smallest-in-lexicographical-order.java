class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            long steps = countSteps(curr, curr + 1, n);

            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private long countSteps(long curr, long next, int n) {
        long steps = 0;

        while (curr <= n) {
            steps += Math.min((long) n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }

        return steps;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna