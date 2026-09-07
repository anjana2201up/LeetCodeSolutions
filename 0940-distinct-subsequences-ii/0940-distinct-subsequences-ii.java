class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int[] dp = new int[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            int sum = 0;
            
            for (int x : dp) {
                sum = (sum + x) % MOD;
            }
            
            dp[idx] = (sum + 1) % MOD;
        }
        
        int ans = 0;
        for (int x : dp) {
            ans = (ans + x) % MOD;
        }
        
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna