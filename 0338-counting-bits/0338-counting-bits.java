class Solution {

    public int[] countBits(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 0;

        for(int i = 1; i <= n; i++) {

            dp[i] = dp[i / 2] + (i % 2);

        }

        return dp;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna