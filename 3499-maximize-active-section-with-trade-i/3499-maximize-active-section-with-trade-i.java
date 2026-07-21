class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        int previousZeroBlock = Integer.MIN_VALUE;
        int maxGain = 0;

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ones += len;
            } else {
                maxGain = Math.max(maxGain, previousZeroBlock + len);
                previousZeroBlock = len;
            }

            i = j;
        }

        return ones + maxGain;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna