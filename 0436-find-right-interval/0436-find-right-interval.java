import java.util.*;

class Solution {

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;

        int[][] starts = new int[n][2];

        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // start
            starts[i][1] = i;               // original index
        }

        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int target = intervals[i][1];

            int left = 0;
            int right = n - 1;

            int idx = -1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (starts[mid][0] >= target) {
                    idx = starts[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = idx;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna