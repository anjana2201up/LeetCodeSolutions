class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] result = new int[k];

        for (int i = Math.max(0, k - nums2.length);
             i <= Math.min(k, nums1.length);
             i++) {

            int[] part1 = getMax(nums1, i);
            int[] part2 = getMax(nums2, k - i);

            int[] merged = merge(part1, part2);

            if (greater(merged, 0, result, 0)) {
                result = merged;
            }
        }

        return result;
    }


    // Get maximum subsequence of length k
    private int[] getMax(int[] nums, int k) {

        int[] stack = new int[k];
        int top = 0;

        int remove = nums.length - k;

        for (int num : nums) {

            while (top > 0 &&
                   remove > 0 &&
                   stack[top - 1] < num) {

                top--;
                remove--;
            }

            if (top < k) {
                stack[top++] = num;
            } else {
                remove--;
            }
        }

        return stack;
    }


    // Merge two sequences
    private int[] merge(int[] a, int[] b) {

        int[] res = new int[a.length + b.length];

        int i = 0, j = 0, index = 0;

        while (i < a.length || j < b.length) {

            if (greater(a, i, b, j)) {
                res[index++] = a[i++];
            } else {
                res[index++] = b[j++];
            }
        }

        return res;
    }


    // Compare two sequences
    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length &&
               a[i] == b[j]) {

            i++;
            j++;
        }

        return j == b.length ||
              (i < a.length && a[i] > b[j]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna