class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // If taking all cards
        if (k == n) {
            int total = 0;
            for (int x : cardPoints)
                total += x;
            return total;
        }

        int totalSum = 0;
        for (int x : cardPoints)
            totalSum += x;

        int windowSize = n - k;

        int left = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += cardPoints[right];

            if (right - left + 1 == windowSize) {

                minSum = Math.min(minSum, sum);

                sum -= cardPoints[left];
                left++;
            }
        }

        return totalSum - minSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna