class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int max = 0;

        for (int g : gain) {
            current += g;
            max = Math.max(max, current);
        }

        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna