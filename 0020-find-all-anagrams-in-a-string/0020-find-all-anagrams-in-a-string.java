class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] countP = new int[26];
        int[] countS = new int[26];
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }
        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {  
            countS[s.charAt(i) - 'a']++;
            if (i >= windowSize) {
                countS[s.charAt(i - windowSize) - 'a']--;
            }
            if (Arrays.equals(countP, countS)) {
                result.add(i - windowSize + 1);
            }
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna