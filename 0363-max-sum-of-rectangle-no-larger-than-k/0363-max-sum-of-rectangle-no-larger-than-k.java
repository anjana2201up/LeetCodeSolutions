import java.util.TreeSet;

class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int answer = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {

            int[] rowSum = new int[rows];

            for (int right = left; right < cols; right++) {

                for (int r = 0; r < rows; r++)
                    rowSum[r] += matrix[r][right];

                answer = Math.max(answer, maxSubArrayNoMoreThanK(rowSum, k));

                if (answer == k)
                    return k;
            }
        }

        return answer;
    }

    private int maxSubArrayNoMoreThanK(int[] nums, int k) {

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);

        int prefix = 0;

        int ans = Integer.MIN_VALUE;

        for (int x : nums) {

            prefix += x;

            Integer ceil = set.ceiling(prefix - k);

            if (ceil != null)
                ans = Math.max(ans, prefix - ceil);

            set.add(prefix);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna