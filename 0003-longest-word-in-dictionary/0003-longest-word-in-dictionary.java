class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        Set<String> set = new HashSet<>();
        String ans = "";

        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);

                if (word.length() > ans.length()) {
                    ans = word;
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna