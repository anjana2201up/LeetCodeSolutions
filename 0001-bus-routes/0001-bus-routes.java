class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        boolean[] visitedBuses = new boolean[routes.length];

        queue.offer(source);
        visitedStops.add(source);

        int buses = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            buses++;

            while (size-- > 0) {
                int stop = queue.poll();

                List<Integer> busList = stopToBuses.get(stop);
                if (busList == null) continue;

                for (int bus : busList) {
                    if (visitedBuses[bus]) continue;

                    visitedBuses[bus] = true;

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) {
                            return buses;
                        }

                        if (visitedStops.add(nextStop)) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna