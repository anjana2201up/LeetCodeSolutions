class Solution {
    public int findNthDigit(int n) {

        long digits = 1;
        long count = 9;
        long start = 1;

        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }

        long number = start + (n - 1) / digits;
        int index = (int)((n - 1) % digits);

        // Remove digits from the right until the target digit is at the end
        for (int i = 0; i < digits - index - 1; i++) {
            number /= 10;
        }

        return (int)(number % 10);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna