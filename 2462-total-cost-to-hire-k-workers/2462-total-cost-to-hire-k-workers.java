import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int n = costs.length;
        int left = 0;
        int right = n - 1;

        // Fill left heap
        while (left < candidates && left <= right) {
            leftHeap.offer(costs[left]);
            left++;
        }

        // Fill right heap
        while (right >= n - candidates && left <= right) {
            rightHeap.offer(costs[right]);
            right--;
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {

            int leftCost = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int rightCost = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();

            if (leftCost <= rightCost) {
                ans += leftHeap.poll();

                if (left <= right) {
                    leftHeap.offer(costs[left]);
                    left++;
                }
            } else {
                ans += rightHeap.poll();

                if (left <= right) {
                    rightHeap.offer(costs[right]);
                    right--;
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna