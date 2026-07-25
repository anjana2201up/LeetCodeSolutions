import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if(x != y) {
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna