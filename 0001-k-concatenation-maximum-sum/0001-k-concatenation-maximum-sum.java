class Solution {
    private static final int MOD = 1_000_000_007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        long total = 0;
        for (int num : arr) {
            total += num;
        }

        long maxSum = kadane(arr, Math.min(k, 2));

        if (k > 2 && total > 0) {
            maxSum += (long) (k - 2) * total;
        }

        return (int) (maxSum % MOD);
    }

    private long kadane(int[] arr, int times) {
        long max = 0;
        long curr = 0;

        for (int t = 0; t < times; t++) {
            for (int num : arr) {
                curr = Math.max(0, curr + num);
                max = Math.max(max, curr);
            }
        }

        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna