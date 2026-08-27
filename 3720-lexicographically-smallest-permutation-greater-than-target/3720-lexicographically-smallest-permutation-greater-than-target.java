class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] cnt = freq.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (cnt[x] == 0) {
                    possible = false;
                    break;
                }

                cnt[x]--;
            }

            if (!possible) continue;

            int cur = target.charAt(i) - 'a';

            for (int c = cur + 1; c < 26; c++) {
                if (cnt[c] == 0) continue;

                StringBuilder ans = new StringBuilder();
                ans.append(target, 0, i);
                ans.append((char) ('a' + c));
                cnt[c]--;

                for (int x = 0; x < 26; x++) {
                    while (cnt[x]-- > 0) {
                        ans.append((char) ('a' + x));
                    }
                }

                return ans.toString();
            }
        }

        return "";
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna