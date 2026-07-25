import java.util.*;

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for(int num : target) {
            pq.add((long)num);
            sum += num;
        }

        while(pq.peek() != 1) {
            long max = pq.poll();
            long rest = sum - max;

            if(rest == 1)
                return true;

            if(rest == 0 || max <= rest)
                return false;

            long prev = max % rest;

            if(prev == 0)
                return false;

            pq.add(prev);
            sum = rest + prev;
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna