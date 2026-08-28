class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1) return "";

        int m = n / 2;
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        String targetHalf = target.substring(0, m);

        int[] rem = half.clone();
        boolean possible = true;

        for (int i = 0; i < m; i++) {
            int x = targetHalf.charAt(i) - 'a';

            if (rem[x] == 0) {
                possible = false;
                break;
            }

            rem[x]--;
        }

        if (possible) {
            if (n % 2 == 1) {
                int targetMid = target.charAt(m) - 'a';

                if (mid > targetMid) {
                    return build(targetHalf, mid);
                }

                if (mid == targetMid) {
                    String candidate = build(targetHalf, mid);

                    if (candidate.compareTo(target) > 0) {
                        return candidate;
                    }
                }
            } else {
                String candidate = build(targetHalf, -1);

                if (candidate.compareTo(target) > 0) {
                    return candidate;
                }
            }
        }

        for (int pos = m - 1; pos >= 0; pos--) {
            int[] cur = half.clone();
            boolean ok = true;

            for (int i = 0; i < pos; i++) {
                int x = targetHalf.charAt(i) - 'a';

                if (cur[x] == 0) {
                    ok = false;
                    break;
                }

                cur[x]--;
            }

            if (!ok) continue;

            int targetChar = targetHalf.charAt(pos) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {
                if (cur[c] == 0) continue;

                cur[c]--;

                StringBuilder left = new StringBuilder();

                for (int i = 0; i < pos; i++) {
                    left.append(targetHalf.charAt(i));
                }

                left.append((char) ('a' + c));

                for (int x = 0; x < 26; x++) {
                    while (cur[x] > 0) {
                        left.append((char) ('a' + x));
                        cur[x]--;
                    }
                }

                return build(left.toString(), mid);
            }
        }

        return "";
    }

    private String build(String left, int mid) {
        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (mid != -1) {
            ans.append((char) ('a' + mid));
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna