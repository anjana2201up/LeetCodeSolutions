class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;

        for(char c : word.toCharArray()) {
            if(Character.isUpperCase(c))
                count++;
        }

        return count == word.length() || count == 0 || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna