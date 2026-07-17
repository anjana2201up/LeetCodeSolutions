class Solution {

    public int numTilings(int n) {

        int mod = 1000000007;

        if(n == 1)
            return 1;

        if(n == 2)
            return 2;

        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod;
        }

        return (int)dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna