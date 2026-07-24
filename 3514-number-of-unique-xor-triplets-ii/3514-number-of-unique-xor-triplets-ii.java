class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            boolean[] seen = new boolean[2048];
            int ans = 0;
            for (int x : nums) {
                if (!seen[x]) {
                    seen[x] = true;
                    ans++;
                }
            }
            return ans;
        }
        boolean[] pairXor = new boolean[2048];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] tripletXor = new boolean[2048];
        for (int v = 0; v < 2048; v++) {
            if (pairXor[v]) {
                for (int x : nums) {
                    tripletXor[v ^ x] = true;
                }
            }
        }
        int ans = 0;
        for (boolean b : tripletXor) {
            if (b) ans++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna