class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prev = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode p = head;
        ListNode q = head.next;
        int index = 1;

        while (q != null && q.next != null) {
            if ((q.val > p.val && q.val > q.next.val) ||
                (q.val < p.val && q.val < q.next.val)) {

                if (first == -1) {
                    first = index;
                } else {
                    minDist = Math.min(minDist, index - prev);
                }

                prev = index;
            }

            p = q;
            q = q.next;
            index++;
        }

        if (first == -1 || first == prev) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, prev - first};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna