import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int n = spells.length;
        int m = potions.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = m - 1;
            int index = m;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if ((long) spells[i] * potions[mid] >= success) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = m - index;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna