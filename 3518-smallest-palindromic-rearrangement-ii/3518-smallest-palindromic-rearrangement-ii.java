class Solution {
    private static final long MAX_K = 1000001;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
                freq[i]--;
                break;
            }
        }
        int[] half = new int[26];
        int len = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
        }
        if (k > multinomial(half)) return "";
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;
                half[c]--;
                long ways = multinomial(half);
                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }
                k -= (int) ways;
                half[c]++;
            }
        }
        String first = left.toString();
        String second = new StringBuilder(first).reverse().toString();
        return mid == 0 ? first + second : first + mid + second;
    }

    private long multinomial(int[] cnt) {
        int total = 0;
        for (int x : cnt) total += x;
        long res = 1;
        for (int i = 0; i < 26; i++) {
            res *= binom(total, cnt[i]);
            if (res >= MAX_K) return MAX_K;
            total -= cnt[i];
        }
        return res;
    }

    private long binom(int n, int k) {
        if (k > n) return 0;
        if (k > n - k) k = n - k;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_K) return MAX_K;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna