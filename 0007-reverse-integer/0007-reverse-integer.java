class Solution {
    public int reverse(int x) {

        int rev = 0;

        while (x != 0) {

            int digit = x % 10;
            x = x / 10;

            // Check positive overflow
            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            // Check negative overflow
            if (rev < Integer.MIN_VALUE / 10 ||
                (rev == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            rev = rev * 10 + digit;
        }

        return rev;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna