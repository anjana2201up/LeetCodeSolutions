class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;

        return (s + s).contains(goal);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna